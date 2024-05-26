package org.example;

public class Admin {

    private final MovieRepository movies = MovieRepository.getInstance();
    private final UserRepository users = UserRepository.getInstance();

    private final String login;

    public static String getAuthenticationCode() {
        return "9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08"; // "test"
    }

    public Admin(String login) {
        this.login = login;
    }

    public Boolean addMovie(Movie movie) {
        for (Movie m : movies.getMovies()) {
            if (movie.getName().equals(m.getName())) return false;
        }
        movies.getMovies().add(movie);
        return true;
    }

    public boolean returnPhysicalMovie(String movieName) {
        for (Movie m : movies.getMovies()) {
            if (m.getClass().getSimpleName().equals("PhysicalMovie")) {
                if (m.getName().equals(movieName) && !((PhysicalMovie) m).isAvaliable()) {
                    ((PhysicalMovie) m).setAvaliable(true);
                    System.out.println("Zwrócono fizyczną kopię: " + movieName);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteMovie(String toDelete) {
        for (Movie m : movies.getMovies()){
            if (m.getName().equals(toDelete) && !m.getClass().getSimpleName().equals("PhysicalMovie")) {
                Movie movie = movies.getMovie(toDelete);
                movies.getMovies().remove(movie);
                return true;
            }
        }
        return false;
    }

    public void printUsers(){
        for (User user : users.getUsers()){
            System.out.println(user);
        }
    }
    // piła 5
}
