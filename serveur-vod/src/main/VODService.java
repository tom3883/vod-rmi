package main;

import contrat.Bill;
import contrat.IClientBox;
import contrat.IVODService;
import contrat.MovieDesc;

import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class VODService extends UnicastRemoteObject implements IVODService {

    List<MovieDesc> movies;

    public VODService() throws RemoteException{
        this.movies = new ArrayList<>();
        MovieDesc m1 = new MovieDesc("OSS 117", "1", "Agent secret");
        MovieDesc m2 = new MovieDesc("Les bronzés font du ski", "2", "Vacances d'hiver entre amis");
        movies.add(m1);
        movies.add(m2);
    }

    public List<MovieDesc> viewCatalog() throws RemoteException {
        return this.movies;
    }

    public Bill playMovie(String isbn, IClientBox box) throws RemoteException {
        String movieContent = "coucou";
        System.out.println("Playing movie...");
        box.stream(movieContent.getBytes(StandardCharsets.UTF_8));
        System.out.println("End of movie.");
        return new Bill(isbn, 5);
    }
}
