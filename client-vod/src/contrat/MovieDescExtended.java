package contrat;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class MovieDescExtended extends MovieDesc {
    byte[] teaser;

    public MovieDescExtended(String movieName, String isbn, String synopsis, byte[] teaser){
        super(movieName, isbn, synopsis);
        this.teaser = teaser;
    }

    public byte[] getTeaser() {
        return teaser;
    }

    public void setTeaser(byte[] teaser) {
        this.teaser = teaser;
    }

    @Override
    public String toString() {
        String t = new String(teaser, StandardCharsets.UTF_8);
        return "Name : " + movieName + "\n" +
                "ISBN : " + isbn + "\n" +
                "Synopsis : " + synopsis + "\n" +
                "Teaser : " + t + "\n";
    }
}
