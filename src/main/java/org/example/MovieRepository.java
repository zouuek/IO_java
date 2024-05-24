package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MovieRepository {
    private Collection <Movie> movies;
    private static MovieRepository instance;
    public Collection<Movie> getMovies() {
        return movies;
    }
    public Movie getMovie(String name){
        for (Movie movie: movies){
            if (movie.getName().equals(name)) return movie;
        }
        return null;
    }
    private MovieRepository(){
        movies = new ArrayList<Movie>();
    }
    public static MovieRepository getInstance(){
        if (instance == null){
            instance = new MovieRepository();
        }
        return instance;
    }

}
