package main;

public class Bill {
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
}
