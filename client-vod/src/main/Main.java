package main;

import contrat.IConnection;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.getRegistry(2001);
            IConnection c = (IConnection) reg.lookup("VOD");
            System.out.println("Lancement de la connection...");

        } catch (RemoteException | NotBoundException e){
            e.printStackTrace();
        }
    }
}
