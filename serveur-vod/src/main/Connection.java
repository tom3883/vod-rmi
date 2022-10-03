package main;

import contrat.IConnection;
import exceptions.InvalidCredentialsException;
import exceptions.SignUpFailed;

import java.rmi.RemoteException;

public class Connection implements IConnection {
    @Override
    public boolean signUp(String mail, String password) throws SignUpFailed, RemoteException {
        return false;
    }

    @Override
    public boolean logIn(String mail, String password) throws InvalidCredentialsException {
        return false;
    }
}
