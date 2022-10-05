package contrat;

import java.io.Serializable;

public class MovieDesc implements Serializable {
    String movieName;
    String isbn;
    String synopsis;

    public MovieDesc(String movieName, String isbn, String synopsis) {
        this.movieName = movieName;
        this.isbn = isbn;
        this.synopsis = synopsis;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getSynopsis() {
        return synopsis;
    }

    @Override
    public String toString() {
        return  "Name : " + movieName + "\n" +
                "ISBN : " + isbn + "\n" +
                "Synopsis : " + synopsis + "\n";
    }
}
