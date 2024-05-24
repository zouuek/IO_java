package org.example;

public class PhysicalMovie extends Movie{
    private Boolean isAvaliable;
    public PhysicalMovie(String name, String director, String genre, Double price, Boolean isAvaliable) {
        super(name, director, genre, price);
        this.isAvaliable = isAvaliable;
    }

    public Boolean getAvaliable() {
        return isAvaliable;
    }

    public void setAvaliable(Boolean avaliable) {
        isAvaliable = avaliable;
    }
}
