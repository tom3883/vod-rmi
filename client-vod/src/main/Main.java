package main;

import contrat.*;
import exceptions.InvalidCredentialsException;
import exceptions.SignUpFailed;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    static IConnection ic;
    static IVODService service;

    static void askForConnection(Requests req){
        String answer = req.displayRegisterOrConnection();

        if(answer.equals("y")){
            System.out.println("Connection :");
            req.inputCredentials();
            try {
                service = ic.logIn(req.getEmail(), req.getPassword());
            } catch (RemoteException | InvalidCredentialsException e) {
                System.out.println("Invalid credentials, you can retry");
                askForConnection(req);
            }
        } else if(answer.equals("n")) {
            System.out.println("Register :");
            req.inputCredentials();
            try {
                ic.signUp(req.getEmail(), req.getPassword());
                service = ic.logIn(req.getEmail(), req.getPassword());
            } catch (RemoteException | InvalidCredentialsException | SignUpFailed e) {
                System.out.println("Email adress already used, you can retry");
                askForConnection(req);
            }
        } else {
            System.out.println("Input not valid");
            askForConnection(req);
        }
    }

    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.getRegistry(2001);
            ic = (IConnection) reg.lookup("VOD");
            System.out.println("Lancement de la connection...");

            Requests req = new Requests();
            askForConnection(req);

            System.out.println("Here is the catalog of movies on demand:");

            for(MovieDesc m : service.viewCatalog()){
                System.out.println(m.toString());
            }

            String answer = req.chooseAMovie();
            ClientBox cbox = new ClientBox();
            Bill bill = service.playMovie(answer, cbox);
            System.out.println(bill.toString());


        } catch (RemoteException | NotBoundException e){
            e.printStackTrace();
        }
    }
}
