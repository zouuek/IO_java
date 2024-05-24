package org.example;

public class Movie {
    private String name;
    private String director;
    private String genre;
    private Double price;
    private Double rating;
    private Integer numberOfRatings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Movie(String name, String director, String genre, Double price) {
        this.name = name;
        this.director = director;
        this.genre = genre;
        this.price = price;
        this.rating = 0.0;
        this.numberOfRatings = 0;
    }

    public Integer getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(Integer numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    @Override
    public String toString() {
        return name + " " + director + " " + genre + "\n" +price + " " + rating +" "+ numberOfRatings;
    }
}
