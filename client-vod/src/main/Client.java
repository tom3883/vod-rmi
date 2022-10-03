package main;

public class Client {
    String password;
    String mail;

    Client(String mail, String pwd){
        this.password = pwd;
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }
}
