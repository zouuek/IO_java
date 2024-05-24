package org.example;

import java.util.Collection;

public class User {
    private String login;
    private String password;
    private Collection<Movie> rentedMovies;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String login, String password, Collection<Movie> rentedMovies) {
        this.login = login;
        this.password = password;
        this.rentedMovies = rentedMovies;
    }

    // private MovieRepository movieRepository;
    Boolean rentMovie(String movieName){
        MovieRepository movieRepository = MovieRepository.getInstance();
        for(Movie movie : movieRepository.getMovies()){

            if(movie.getName().equals(movieName)){
                if (movie.getClass().getSimpleName().equals("DigitalMovie")){
                    rentedMovies.add(movie);
                    return true;
                }
                else if(movie.getClass().getSimpleName().equals("PhysicalMovie")){
                    if(((PhysicalMovie) movie).getAvaliable()){
                        rentedMovies.add(movie);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public Boolean returnMovie(String movieName){

        for(Movie movie: rentedMovies){
            if(movie.getName().equals(movieName)){
                if(movie.getClass().getSimpleName().equals("PhysicalMovie")){return false;}
                rentedMovies.remove(movie);
                return true;
            }
        }
        return false;
    }
    public void rateMovie(String movieName, Integer rating){
        for(Movie movie: rentedMovies){
            if(movie.getName().equals(movieName)){
                int number = movie.getNumberOfRatings();
                movie.setRating(rating+ movie.getRating() / number + 1);
            }
        }

    }
    public void displayMovies(){
        MovieRepository movieRepository = MovieRepository.getInstance();
        for(Movie movie: movieRepository.getMovies()){
            System.out.println(movie);
        }
    }
    public void displayRentedMovies(){
        for(Movie movie: rentedMovies){
            System.out.println(movie);
        }
    }
}
