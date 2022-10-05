package contrat;

import java.io.Serializable;

public class Bill implements Serializable {
    String movieName;
    Integer price;

    public Bill(String movieName, Integer price) {
        this.movieName = movieName;
        this.price = price;
    }

    public String getMovieName() {
        return movieName;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "The price to pay for the movie " + movieName + " is " + price + "€";
    }
}
