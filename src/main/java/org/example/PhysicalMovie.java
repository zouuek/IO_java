package org.example;

public class PhysicalMovie extends Movie {
    private Boolean isAvaliable;

    public PhysicalMovie(String name, String director, String genre, Double price) {
        super(name, director, genre, price);
        this.isAvaliable = true;
    }
    public PhysicalMovie(String name, String director, String genre, Double price, Double rating, Integer numberOfRatings) {
        super(name,director,genre,price,rating,numberOfRatings);
        this.isAvaliable = true;
    }


    public Boolean isAvaliable() {
        return isAvaliable;
    }

    public void setAvaliable(Boolean avaliable) {
        isAvaliable = avaliable;
    }
}
