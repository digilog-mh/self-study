package hello.servlet.web.frontController.v1;

import hello.servlet.web.frontController.v1.controller.MemberFromControllerV1;
import hello.servlet.web.frontController.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontController.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV1",urlPatterns = "/front-controller/v1/*")
public class frontControllerServletV1 extends HttpServlet {

    private Map<String,ControllerV1> controllerV1Map = new HashMap<>();

    public frontControllerServletV1(){
        controllerV1Map.put("/front-controller/v1/members/new-form",new MemberFromControllerV1());
        controllerV1Map.put("/front-controller/v1/members/save",new MemberSaveControllerV1());
        controllerV1Map.put("/front-controller/v1/members",new MemberListControllerV1());
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");

        String requestUrl = req.getRequestURI();

        ControllerV1 controllerV1 = controllerV1Map.get(requestUrl);
        if (controllerV1 == null){
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controllerV1.process(req,res);
    }

    /*View 분리 - v2, 76p*/
}
