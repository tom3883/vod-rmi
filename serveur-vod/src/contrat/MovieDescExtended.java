package contrat;

public class MovieDescExtended extends MovieDesc {
    byte[] teaser;

    MovieDescExtended(String movieName, String isbn, String synopsis, byte[] teaser){
        super(movieName, isbn, synopsis);
        this.teaser = teaser;
    }

    public byte[] getTeaser() {
        return teaser;
    }
}
