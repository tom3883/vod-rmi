package contrat;

import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;

public class ThreadStream implements Runnable{
    MovieDesc movie;
    IClientBox box;

    public ThreadStream(MovieDesc movie, IClientBox box){
        this.movie = movie;
        this.box = box;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            box.stream(movie.getIsbn().getBytes(StandardCharsets.UTF_8));
            Thread.sleep(2000);
            box.stream(movie.getSynopsis().getBytes(StandardCharsets.UTF_8));
            Thread.sleep(2000);
        } catch (RemoteException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
