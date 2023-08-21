package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/*
*
* 1. 파미터 전송 기능.
*
* */

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class requestParameter extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("전체 파라미터 조회 - s");

        req.getParameterNames().asIterator().forEachRemaining(paramName -> System.out.println(paramName + "=" + req.getParameter(paramName)));
        System.out.println("전체 파라미터 조회 - e");
        System.out.println();

        System.out.println("단일 파라미터 조회");
        String username = req.getParameter("username");
        System.out.println(username);
        System.out.println();

        System.out.println("복수 파라미터 조회");
        String [] usernames = req.getParameterValues("username");
        for (String name : usernames){
            System.out.println(name);
        }

        resp.getWriter().write("ok");
    }
}
