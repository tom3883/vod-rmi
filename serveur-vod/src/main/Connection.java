package main;

import contrat.IConnection;
import contrat.IVODService;
import exceptions.InvalidCredentialsException;
import exceptions.SignUpFailed;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Connection extends UnicastRemoteObject implements IConnection {
    List<Client> clientList;
    VODService service;

    public Connection(int numport) throws RemoteException{
        super(numport);
        clientList = new ArrayList<>();
        for(Client c : clientList){
            System.out.println(c.getMail());
        }
        this.service = new VODService();
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

    public IVODService getIVODServiceAccess() throws RemoteException {
        return service;
    }
}
