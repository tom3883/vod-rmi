package main;

import contrat.IVODService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class VODService implements IVODService {

    public List<MovieDesc> viewCatalog() throws RemoteException {
        List<MovieDesc> movies = new ArrayList<>();

        MovieDesc m1 = new MovieDesc("OSS 117", "1", "Agent secret");
        MovieDesc m2 = new MovieDesc("Les bronzés font du ski", "2", "Vacances d'hiver entre amis");
        movies.add(m1);
        movies.add(m2);

        return movies;
    }

    /*public Bill playmovie(String isbn, int a) throws RemoteException {

    }*/
}
