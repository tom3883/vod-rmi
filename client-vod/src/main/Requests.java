package main;

import contrat.IConnection;
import exceptions.InvalidCredentialsException;
import exceptions.SignUpFailed;

import java.rmi.RemoteException;
import java.util.Scanner;

public class Requests {
    String email;
    String password;
    String isbn;
    Scanner scanner;

    Requests(){
        scanner = new Scanner(System.in);
    }

    public String displayRegisterOrConnection() {
        System.out.println("Do you have an account (y/n) ?");
        String answer = scanner.next();
        return answer;
    }

    public void inputCredentials(){
        System.out.println("Enter your email : ");
        String email = scanner.next();
        System.out.println("\nEnter your password : ");
        String password = scanner.next();
        setEmail(email);
        setPassword(password);
    }

    String chooseAMovie(){
        System.out.println("Please select a movie you would like to watch (input isbn) : ");
        String answer = scanner.next();
        System.out.println("You chose the movie " + answer);
        isbn = answer;
        return answer;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
