package OurServlets;

import static Utilities.OurXML.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class Servlet_register extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getRealPath("\\xml_code");
        Document document = null;
        Element rootElement = null;
        path += "\\storage.xml";
        System.out.println(" ->-> "+path);
        File file = new File(path);
        SAXBuilder saxBuilder = new SAXBuilder();
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String last_name = request.getParameter("last_name");
        String email = request.getParameter("email");
        String user_name = request.getParameter("user");
        String password = request.getParameter("password");
        
        /** BEGIN XML treat**/
        try {
            //The file exists
            if (file.exists()) {
                System.out.println("File exists ");
                //FileInputStream fileInputStream = new FileInputStream(file);
                //SAXBuilder saxBuilder = new SAXBuilder();
                document = saxBuilder.build(file);
                rootElement = document.getRootElement();
                //fileInputStream.close();
            } //The file doesn't exists
            else {
                System.out.println("File doesn't exists");
                document = new Document();
                rootElement = new Element(ROOT);
            }
            System.out.println("adding a user data");
            Element child = new Element(USER);
            child.addContent(new Element(NAME).setText(name));
            child.addContent(new Element(LAST_NAME).setText(last_name));
            child.addContent(new Element(USER_NAME).setText(user_name));
            child.addContent(new Element(PASSWORD).setText(password));
            child.addContent(new Element(EMAIL).setText(email));
            child.addContent(new Element(PROJECTS).setText("algo"));
            rootElement.addContent(child);
            //document.setContent(rootElement);
            System.out.println("Creating file outputStreeam");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            //FileWriter fileWriter = new FileWriter(path);
            XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
            xmlOutputter.output(document, fileOutputStream);
            xmlOutputter.output(document, System.out);
            fileOutputStream.flush();
            fileOutputStream.close();
            //FileOutputStream fileOutputStream = new FileOutputStream(file);
        //xmlOutputter.output(document, fileOutputStream);
            //xmlOutputter.setFormat(Format.getPrettyFormat());   
            //xmlOutputter.output(document, fileWriter);
            //xmlOutputter.output(document, System.out);
            //fileWriter.flush();
            //fileWriter.close();

        } catch(IOException e){ 
            System.err.println("An IOException has occurred " + e);
        } catch (Exception e) {
            System.err.println("An exception has occurred searching the XML document " + e);
        }
        /** END XML treat **/
    }

    /**
     * This method adds an user in the XML code using the datas captured in the form register
     * Parameters: Five strings that are the datas of an user
     * Return: An element object that contains infomation about an user
     **/
    private Element setUserDatas(Element element, String name, String last_name, String user_name, 
            String password, String email) throws Exception{
        System.out.println("setUserDatas name = [" + name + "] last_name = [" + last_name + "] user_name = [" + user_name + "]"
                + " password = [" + password +"] = email = [" + email + "]");
        //Element element = new Element(USER);    
        element.addContent(new Element(NAME).setText(name));
        element.addContent(new Element(LAST_NAME).setText(last_name));
        element.addContent(new Element(USER_NAME).setText(user_name));
        element.addContent(new Element(PASSWORD).setText(password));
        element.addContent(new Element(EMAIL).setText(email));
        element.addContent(new Element(PROJECTS).setText("algo"));
        return element;
    }
}
