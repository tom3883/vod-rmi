package main;

import contrat.*;
import exceptions.MovieNotExisting;

import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class VODService extends UnicastRemoteObject implements IVODService {

    List<MovieDesc> movies;

    public VODService() throws RemoteException {
        this.movies = new ArrayList<>();
        MovieDesc m1 = new MovieDesc("OSS 117", "1", "Agent secret");
        MovieDesc m2 = new MovieDesc("Les bronzés font du ski", "2", "Vacances d'hiver entre amis");
        MovieDescExtended m3 = new MovieDescExtended("Camping", "3", "Vacances au camping entre amis", "Alors on attends pas patrick ?!".getBytes(StandardCharsets.UTF_8));
        movies.add(m1);
        movies.add(m2);
        movies.add(m3);
    }

    public List<MovieDesc> viewCatalog() throws RemoteException {
        return this.movies;
    }

    public Bill playMovie(String isbn, IClientBox box) throws RemoteException, MovieNotExisting {
        MovieDesc movieSelected=null;
        for(MovieDesc m : movies){
            if(m.getIsbn().equals(isbn)){
                movieSelected = m;
            }
        }
        if(movieSelected==null) throw new MovieNotExisting();
        System.out.println("Playing movie : " + movieSelected.getIsbn());
        box.stream(movieSelected.getMovieName().getBytes(StandardCharsets.UTF_8));
        ThreadStream thread1 = new ThreadStream(movieSelected, box);
        thread1.run();
        System.out.println("End of movie : " + movieSelected.getIsbn());
        return new Bill(isbn, 5);
    }
}
