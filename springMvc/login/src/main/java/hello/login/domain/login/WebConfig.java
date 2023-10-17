package hello.login.domain.login;

import hello.login.web.Interceptor.LogInterceptor;
import hello.login.web.Interceptor.LoginCheckInterceptor;
import hello.login.web.filter.LogFilter;
import hello.login.web.filter.LoginCheckFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/*.ico", "/error");

        registry.addInterceptor(new LoginCheckInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/", "/members/add", "/login", "/logout",
                        "/css/**", "/*.ico", "/error"
                );
    }

    //@Bean
    public FilterRegistrationBean logFilter(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new LogFilter()); //추가 필터
        filterFilterRegistrationBean.setOrder(1); //순서 지정
        filterFilterRegistrationBean.addUrlPatterns("/*"); //필터 적용할 url 패턴 지정.

        return filterFilterRegistrationBean;
    }

   // @Bean
    public FilterRegistrationBean LoginCheckFilter(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new LoginCheckFilter());
        filterFilterRegistrationBean.setOrder(2);
        filterFilterRegistrationBean.addUrlPatterns("/*");

        return filterFilterRegistrationBean;
        /*메서드 호출로 성능 저하의 여부는 걱정하지 않아도 됨.*/
    }


}
