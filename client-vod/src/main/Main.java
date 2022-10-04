package main;

import contrat.IConnection;
import contrat.IVODService;
import contrat.MovieDesc;
import exceptions.InvalidCredentialsException;
import exceptions.SignUpFailed;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Main {
    static IConnection ic;
    static IVODService service;

    static void askForConnection(){
        RequestConnection rq = new RequestConnection();
        String answer = rq.displayRegisterOrConnection();

        if(answer.equals("y")){
            System.out.println("Connection :");
            rq.inputCredentials();
            try {
                service = ic.logIn(rq.getEmail(), rq.getPassword());
            } catch (RemoteException | InvalidCredentialsException e) {
                System.out.println("Invalid credentials, you can retry");
                askForConnection();
            }
        } else if(answer.equals("n")) {
            System.out.println("Register :");
            rq.inputCredentials();
            try {
                ic.signUp(rq.getEmail(), rq.getPassword());
                service = ic.logIn(rq.getEmail(), rq.getPassword());
            } catch (InvalidCredentialsException | RemoteException | SignUpFailed e) {
                System.out.println("Email adress already used, you can retry");
                askForConnection();
            }
        } else {
            System.out.println("Input not valid");
            rq.displayRegisterOrConnection();
        }
    }

    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.getRegistry(2001);
            ic = (IConnection) reg.lookup("VOD");
            System.out.println("Lancement de la connection...");

            askForConnection();

            System.out.println("Here is the catalog of movies on demand:");

            for(MovieDesc m : service.viewCatalog()){
                System.out.println(m.toString());
            }

        } catch (RemoteException | NotBoundException e){
            e.printStackTrace();
        }
    }
}
