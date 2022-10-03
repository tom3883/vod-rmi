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

public class Main {

    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.getRegistry(2001);
            IConnection ic = (IConnection) reg.lookup("VOD");
            System.out.println("Lancement de la connection...");

            RequestConnection rq = new RequestConnection();
            String answer = rq.displayRegisterOrConnection();

            if(answer.equals("y")){
                System.out.println("Connection :");
                rq.inputCredentials();
                ic.logIn(rq.getEmail(), rq.getPassword());
            } else if(answer.equals("n")) {
                System.out.println("Register :");
                rq.inputCredentials();
                ic.signUp(rq.getEmail(), rq.getPassword());
            } else {
                System.out.println("Input not valid");
                rq.displayRegisterOrConnection();
            }

            System.out.println("Here is the catalog of movies on demand:");
            IVODService service = ic.getIVODServiceAccess();

            for(MovieDesc m : service.viewCatalog()){
                System.out.println(m.toString());
            }

        } catch (RemoteException | NotBoundException | SignUpFailed | InvalidCredentialsException e){
            e.printStackTrace();
        }
    }
}
