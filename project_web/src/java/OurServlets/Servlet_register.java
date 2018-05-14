package OurServlets;

import static Utilities.OurXML.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class Servlet_register extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Document document = null;
        Element rootElement = null;
        File file = new File("");
        
        response.setContentType("text/html;charset=UTF-8");
         
        String name = request.getParameter("name");
        String last_name = request.getParameter("last_name");
        String email = request.getParameter("email");
        String user_name = request.getParameter("user");
        String password = request.getParameter("password");

        
        try{
            //The file exists
            if(file.exists()){
                FileInputStream fileInputStream = new FileInputStream(file);
                SAXBuilder saxBuilder = new SAXBuilder();
                document = saxBuilder.build(fileInputStream);
                rootElement = document.getRootElement();
                fileInputStream.close();
            } 
            //The file doesn't exists
            else {
                document = new Document();
                rootElement = new Element(ROOT);
            }
            
            Element child = new Element(USER);
            //child.addContent(new Element);
            
        } catch(Exception e){
            System.err.println("An exception has occurred searching the XML document");
        }
    }
    
            
        private Element setUserDatas(){
            Element element = new Element(USER);
            
            return element;
        }
}
