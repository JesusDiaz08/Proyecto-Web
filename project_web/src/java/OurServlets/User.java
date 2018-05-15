package OurServlets;

/*@author kaimorts*/
public class User {
    private String name;
    private String apellido;
    private String correo;
    private String contrasenia;
    private String usuario;

    
    public User(){
        
    }

    public User(String name, String apellido, String correo, String contrasenia, String usuario) {
        this.name = name;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.usuario = usuario;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
 
    
}
