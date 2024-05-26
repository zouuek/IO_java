package org.example;

public class DigitalMovie extends Movie {
    private final int fileSizeInGB;

    public DigitalMovie(String name, String director, String genre, double price, int fileSizeInGB) {
        super(name, director, genre, price);
        this.fileSizeInGB = fileSizeInGB;
    }
    //wczytywanie z bazy danych
    public DigitalMovie(String name, String director, String genre, Double price, Double rating, Integer numberOfRatings, int fileSizeInGB) {
        super(name,director,genre,price,rating,numberOfRatings);
        this.fileSizeInGB = fileSizeInGB;
    }
    public int getFileSize() {
        return fileSizeInGB;
    }
}
