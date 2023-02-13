package models;

import java.io.Serializable;

/**
 *
 * @author Zeina Mint
 */
public class User implements Serializable {
    private String username;
    private String password;

    public User()
    {
        this.username = "";
        this.password = "";
    }
    
    public User(String username, String password)
    {
        this.username = username;
           this.password = password;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;

    }
}
