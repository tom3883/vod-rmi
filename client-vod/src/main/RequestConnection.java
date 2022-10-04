package main;

import contrat.IConnection;
import exceptions.InvalidCredentialsException;
import exceptions.SignUpFailed;

import java.rmi.RemoteException;
import java.util.Scanner;

public class RequestConnection {
    String email;
    String password;

    public String displayRegisterOrConnection() {
        System.out.println("Do you have an account (y/n) ?");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        return answer;
    }

    public void inputCredentials(){
        System.out.println("Enter your email : ");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.next();
        System.out.println("\nEnter your password : ");
        String password = scanner.next();
        setEmail(email);
        setPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
