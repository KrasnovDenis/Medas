package nc.Medas.service;

public class LoginModel {
    private String username;
    private String password;


    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }



}