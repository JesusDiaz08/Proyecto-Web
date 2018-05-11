package OurServlets;

import java.util.HashMap;

public class LoginValidator {
    
    private HashMap users_registered = new HashMap();
    
    public LoginValidator(){
        users_registered.put("","");
        users_registered.put("","");
    }
    
    
    /**
     * This function search a user and verify if the password
     * is the correct.
     **/
    public boolean validateUser(String user, String password){
        //We search if the user exists and if the password is correct
        return (users_registered.containsKey(user) && users_registered.get(user).equals(password));
    }
}
