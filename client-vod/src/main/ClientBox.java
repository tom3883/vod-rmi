package main;

import contrat.IClientBox;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientBox extends UnicastRemoteObject implements IClientBox  {

    protected ClientBox() throws RemoteException {
    }

    public void stream(byte[] chunck) throws RemoteException {
        String s = new String(chunck, StandardCharsets.UTF_8);
        System.out.println(s);
    }

}
