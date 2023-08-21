package hello.servlet.web.frontController.v3;

import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.MyView;
import hello.servlet.web.frontController.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontController.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontController.v3.controller.MemberFormControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV3",urlPatterns = "/front-controller/v3/*")
public class frontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerV3Map = new HashMap<>();

    public frontControllerServletV3(){
        controllerV3Map.put("/front-controller/v3/members/new-form",new MemberFormControllerV3());
        controllerV3Map.put("/front-controller/v3/members/save",new MemberSaveControllerV3());
        controllerV3Map.put("/front-controller/v3/members",new MemberListControllerV3());
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("FrontControllerServletV3.service");

        String requestUrl = req.getRequestURI();

        ControllerV3 controllerV3 = controllerV3Map.get(requestUrl);
        if (controllerV3 == null){
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //paramMap
        Map<String, String> paramMap = createParamMap(req);
        ModelView mv = controllerV3.process(paramMap);

        String viewName = mv.getViewName(); //논리이름 new-form

        MyView view = viewResolver(viewName);

        view.render(mv.getModel(),req,res);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParamMap(HttpServletRequest req) {
        Map<String,String> paramMap = new HashMap<>();
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
        return paramMap;
    }

    /*View 분리 - v2, 76p*/
}
