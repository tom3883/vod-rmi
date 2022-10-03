package main;

import contrat.IVODService;
import contrat.MovieDesc;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class VODService extends UnicastRemoteObject implements IVODService {

    List<MovieDesc> movies;

    protected VODService() throws RemoteException{
        this.movies = new ArrayList<>();
        MovieDesc m1 = new MovieDesc("OSS 117", "1", "Agent secret");
        MovieDesc m2 = new MovieDesc("Les bronzés font du ski", "2", "Vacances d'hiver entre amis");
        movies.add(m1);
        movies.add(m2);
    }

    public List<MovieDesc> viewCatalog() throws RemoteException {
        return this.movies;
    }

    /*public Bill playmovie(String isbn, int a) throws RemoteException {

    }*/
}
