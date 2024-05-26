package org.example;

import java.util.*;

public class MovieRepository {
    private final List<Movie> movies;
    private static MovieRepository instance;

    public Collection<Movie> getMovies() {
        return movies;
    }

    public Movie getMovie(String name) {
        for (Movie movie : movies) {
            if (movie.getName().equals(name)) return movie;
        }
        return null;
    }

    private MovieRepository() {
        //tutaj mozna dla testow odkomentowac i sie będą domyślnie do repo ladowaly filmy
        movies = new ArrayList<>();
//        movies.add(new DigitalMovie("Inception", "Christopher Nolan", "Sci-Fi", 19.99, 20));
//        movies.add(new DigitalMovie("The Matrix", "The Wachowskis", "Sci-Fi", 14.99, 25));
//        movies.add(new DigitalMovie("Interstellar", "Christopher Nolan", "Sci-Fi", 22.99, 23));
//        movies.add(new PhysicalMovie("Avatar", "James Cameron", "Fantasy", 18.99));
//        movies.add(new PhysicalMovie("Titanic", "James Cameron", "Romance", 20.99));
    }

    public static MovieRepository getInstance() {
        if (instance == null) {
            instance = new MovieRepository();
        }
        return instance;
    }
    public void displayMovies() {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public void displayBestMovies() {
        List<Movie> movieList = new ArrayList<>(movies);
        movieList.sort(Comparator.comparingDouble(Movie::getRating).reversed());
        for (Movie m : movieList) {
            System.out.println(m);
        }
    }
    public void addToRepo(Movie m){
        movies.add(m);
    }
}
