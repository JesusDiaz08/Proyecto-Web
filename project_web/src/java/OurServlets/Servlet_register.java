package OurServlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        String type = request.getParameter("tipo");
        
        System.out.println(type);
        
    }
}
