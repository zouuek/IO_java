package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String login;
    private final String password;
    private final List<Movie> rentedMovies;

    public String getLogin() {
        return login;
    }



    public String getPassword() {
        return password;
    }



    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.rentedMovies = new ArrayList<>();
    }

    // private MovieRepository movieRepository;
    public Boolean rentMovie(String movieName) {
        MovieRepository movieRepository = MovieRepository.getInstance();
        for (Movie movie : movieRepository.getMovies()) {

            if (movie.getName().equals(movieName)) {
                if (movie.getClass().getSimpleName().equals("DigitalMovie")) {
                    rentedMovies.add(movie);
                    return true;
                } else if (movie.getClass().getSimpleName().equals("PhysicalMovie")) {
                    if (((PhysicalMovie) movie).isAvaliable()) {
                        rentedMovies.add(movie);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public Boolean returnMovie(String movieName) {

        for (Movie movie : rentedMovies) {
            if (movie.getName().equals(movieName)) {
                if (movie.getClass().getSimpleName().equals("PhysicalMovie")) {
                    return false;
                }
                rentedMovies.remove(movie);
                return true;
            }
        }
        return false;
    }
    public boolean rateMovie(String movieName, Integer rating) {
        for (Movie movie : rentedMovies) {
            if (movie.getName().equals(movieName)) {
                int number = movie.getNumberOfRatings();
                double currRating = movie.getRating();
//                System.out.println("number = "+ number);
//                System.out.println("userRating = "+ rating);
//                System.out.println("currRating = "+ currRating);
//                System.out.println("xd = "+ (rating + (currRating * number)));
                movie.setRating((rating + (currRating * number)) / (number + 1));
                movie.setNumberOfRatings(movie.getNumberOfRatings()+ 1);
                return true;
            }

        }
        return false;

    }
    public void displayRentedMovies() {
        for (Movie movie : rentedMovies) {
            System.out.println(movie);
        }
    }
    @Override
    public String toString(){
        return this.login+'\n'+this.password;
    }
}
