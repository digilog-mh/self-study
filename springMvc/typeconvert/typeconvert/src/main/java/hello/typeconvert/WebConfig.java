package hello.typeconvert;

import hello.typeconvert.converter.IntegerToStringConverter;
import hello.typeconvert.converter.IpPortToStringConverter;
import hello.typeconvert.converter.StringToIntegerConverter;
import hello.typeconvert.converter.StringToIpPortConverter;
import hello.typeconvert.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry){
        //converter가 formatter보다 우선순위에 들기에 주석처리.
        //registry.addConverter(new StringToIntegerConverter());
        //registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());

        //추가
        registry.addFormatter(new MyNumberFormatter());
    }
}
