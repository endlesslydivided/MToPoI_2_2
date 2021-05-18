package DB;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.DriverManager;

public class User {

    private String login;
    private String password;

    public String getSalt() {
        return salt;
    }

    private String salt;



    public User()
    {

        this.login ="login";
        this.password = "password";
        this.salt = BCrypt.gensalt();
    }
    public User(String login, String password)
    {
        this.login =login;
        this.password = password;
        this.salt = BCrypt.gensalt();
    }

    public String HashPassword()
    {
        String hashed = BCrypt.hashpw(password, salt);
        return hashed;
    }

    public String HashPasswordBySalt(String password,String salt)
    {
        String hashed = BCrypt.hashpw(password, salt);
        return hashed;
    }

}
