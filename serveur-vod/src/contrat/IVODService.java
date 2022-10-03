package contrat;

import main.Bill;
import main.MovieDesc;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IVODService extends Remote {
    List<MovieDesc> viewCatalog() throws RemoteException;
    //Bill playmovie(String isbn, int a) throws RemoteException;
}
