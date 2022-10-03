package contrat;

import exceptions.InvalidCredentialsException;
import exceptions.SignUpFailed;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IConnection extends Remote {
    boolean signUp (String mail, String password) throws SignUpFailed, RemoteException;
    boolean logIn (String mail, String password) throws InvalidCredentialsException;
}
