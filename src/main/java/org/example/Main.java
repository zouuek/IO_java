package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //List<User> users = new ArrayList<>();
        UserRepository users = UserRepository.getInstance();
        users.addUser(new User("bartek","bartek123"));
        users.addUser(new User("tomek","tomek123"));
        users.addUser(new User("kacper","kacper123"));
        users.addUser(new User("michal","michal123"));
        users.addUser(new User("andrzej","andrzej123"));
        MovieRepository movies= MovieRepository.getInstance();
        // baza danych
        movies.addToRepo(new DigitalMovie("Inception", "Christopher Nolan", "Sci-Fi", 19.99, 5.0, 1, 25));
        movies.addToRepo(new DigitalMovie("The Matrix", "The Wachowskis", "Sci-Fi", 14.99, 3.0, 2, 22));
        movies.addToRepo(new DigitalMovie("Interstellar", "Christopher Nolan", "Sci-Fi", 22.99, 1.0, 4, 21));
        movies.addToRepo(new PhysicalMovie("Avatar", "James Cameron", "Fantasy", 18.99, 2.0, 3));
        movies.addToRepo(new PhysicalMovie("Titanic", "James Cameron", "Romance", 20.99, 2.5, 1));

        App app = new App();
        app.run();
    }
}