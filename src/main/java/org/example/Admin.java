package org.example;

public class Admin {
    private String login;
    private String password;
    public Boolean addMovie(Movie movie){
        MovieRepository movieRepository = MovieRepository.getInstance();
        for (Movie m : movieRepository.getMovies()){
            if (movie.getName().equals(m.getName())) return false;
        }
        movieRepository.getMovies().add(movie);
        return true;
    }
    public Boolean returnPhysicalMovie(String movieName, String userLogin){
        MovieRepository movieRepository = MovieRepository.getInstance();
        UserRepository userRepository = UserRepository.getInstance();
        for (Movie m : movieRepository.getMovies()){

        }
    }// piła 5
}
