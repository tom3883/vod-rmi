package main;

import contrat.IConnection;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

    public static void main(String[] args) {
        try{
            IConnection connection = new Connection(10001);
            Registry r = LocateRegistry.createRegistry(2001);
            r.rebind("VOD", connection);
        } catch (RemoteException e){
            e.printStackTrace();
        }

    }
}
