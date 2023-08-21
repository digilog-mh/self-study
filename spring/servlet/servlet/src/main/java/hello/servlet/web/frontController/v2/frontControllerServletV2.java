package hello.servlet.web.frontController.v2;

import hello.servlet.web.frontController.MyView;
import hello.servlet.web.frontController.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontController.v2.controller.MemberSaveControllerV2;
import hello.servlet.web.frontController.v2.controller.MemberformControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV2",urlPatterns = "/front-controller/v2/*")
public class frontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerV2Map = new HashMap<>();

    public frontControllerServletV2(){
        controllerV2Map.put("/front-controller/v2/members/new-form",new MemberformControllerV2());
        controllerV2Map.put("/front-controller/v2/members/save",new MemberSaveControllerV2());
        controllerV2Map.put("/front-controller/v2/members",new MemberListControllerV2());
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("FrontControllerServletV2.service");

        String requestUrl = req.getRequestURI();

        ControllerV2 controllerV2 = controllerV2Map.get(requestUrl);
        if (controllerV2 == null){
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyView myView = controllerV2.process(req,res);
        myView.render(req,res);
    }

    /*View 분리 - v2, 76p*/
}
