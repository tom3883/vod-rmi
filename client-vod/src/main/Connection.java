package main;

import contrat.IConnection;
import exceptions.InvalidCredentialsException;
import exceptions.SignUpFailed;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Connection extends UnicastRemoteObject implements IConnection {
    List<Client> clientList;

    public Connection(int numport) throws RemoteException{
        super(numport);
        clientList = new ArrayList<>();
        for(Client c : clientList){
            System.out.println(c.getMail());
        }
    }

    public void displayRegisterOrConnection() {
        System.out.println("Do you have an account (y/n) ?\n");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        switch(answer){
            case "y" : displayConnection();
            case "n" : displayRegister();
        }
    }

    private void displayRegister() {
        System.out.println("Register :\n Enter your email : ");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.next();
        System.out.println("\n Enter your password : ");
        String password = scanner.next();
        try {
            signUp(email,password);
        } catch (SignUpFailed e) {
            System.out.println("Your email seems to already be used, try again");
            displayRegister();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void displayConnection() {
        System.out.println("Connection :\n Enter your email : ");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.next();
        System.out.println("\n Enter your password : ");
        String password = scanner.next();
        try {
            logIn(email,password);
        } catch (InvalidCredentialsException e) {
            System.out.println("Your email seems to not be valid, try again");
            displayConnection();
        }
    }

    public boolean signUp(String mail, String password) throws SignUpFailed, RemoteException {
        for(Client c : clientList){
            if(c.getMail().equals(mail)){
                throw new SignUpFailed();
            }
        }

        Client newClient = new Client(mail, password);
        clientList.add(newClient);

        return true;
    }

    public boolean logIn(String mail, String password) throws InvalidCredentialsException {
        for(Client c: clientList){
            if(c.getMail().equals(mail) && c.getPassword().equals(password)) return true;
        }

        throw new InvalidCredentialsException();
    }
}
