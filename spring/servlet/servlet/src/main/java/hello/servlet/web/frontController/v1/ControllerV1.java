package hello.servlet.web.frontController.v1;

import org.eclipse.jdt.internal.compiler.lookup.IQualifiedTypeResolutionListener;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV1 {

    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
