package OurServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.Element;

public class Servlet_register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        String name = request.getParameter("nombre");
        String last_name = request.getParameter("apellido");
        String email = request.getParameter("email");
        String user_name = request.getParameter("usuario");
        String password = request.getParameter("contraseña");
        //String type = request.getParameter("tipo");
        
        try{
             Element students = new Element("students"){};
             Element student = new Element("student");
            
        } catch(Exception e) {
            System.err.println("");
        }
    }
}
