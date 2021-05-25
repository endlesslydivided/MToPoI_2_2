package by.kovalev.model;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String login;
    private byte[] passw;

    public User(int id, String login, byte[] passw) {
        this.id = id;
        this.login = login;
        this.passw = passw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public byte[] getPassw() {
        return passw;
    }

    public void setPassw(byte[] passw) {
        this.passw = passw;
    }
}