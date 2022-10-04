package main;

import contrat.IConnection;
import contrat.IVODService;
import exceptions.InvalidCredentialsException;
import exceptions.SignUpFailed;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Connection extends UnicastRemoteObject implements IConnection {
    List<Client> clientList;
    VODService service;

    void updateClientList(){
        clientList.clear();
        try {
            FileReader fileReader = new FileReader("src/db/client.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String ligne;
            while((ligne = bufferedReader.readLine())!= null){
                String[] param = ligne.split(" ");
                if(param!=null) clientList.add(new Client(param[0], param[1]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection(int numport) throws RemoteException{
        super(numport);
        clientList = new ArrayList<>();
        for(Client c : clientList){
            System.out.println(c.getMail());
        }
        this.service = new VODService();
    }

    public boolean signUp(String mail, String password) throws SignUpFailed, RemoteException {

        updateClientList();

        for (Client c : clientList) {
            if (c.getMail().equals(mail)) {
                throw new SignUpFailed();
            }
        }

        String line = mail + " " + password;

        try {
            FileWriter fileWriter = new FileWriter("src/db/client.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("New user : " + mail);

        return true;
    }

    public IVODService logIn(String mail, String password) throws InvalidCredentialsException {

        updateClientList();

        for(Client c: clientList){
            if(c.getMail().equals(mail) && c.getPassword().equals(password)) {
                System.out.println("New connection : "+ mail);
                return service;
            }
        }

        throw new InvalidCredentialsException();
    }
}
