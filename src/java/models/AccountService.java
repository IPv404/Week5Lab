package models;
import java.io.Serializable;
/**
 *
 * @author Zeina Mint
 */
public class AccountService implements Serializable {
    
    //Code by; Youngshin Park
    public User login (String username, String password) {
            if ((username.equals("abe") || username.equals("barb")) && password.equals("password")) {
                return new User(username, null);
            }
            return null;

        }
}
