package org.example;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users;
    private static UserRepository instance;

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public void addUser(User user){
        //dodaje od razu zahashowane haslo do repo
        User hash = new User(user.getLogin(), Authentication.hashPassword(user.getPassword()));
        users.add(hash);
    }

    public UserRepository() {
        //tutaj tak samo jak w movie repo
        users = new ArrayList<>();
//        users.add(new User("bartek","bartek123"));
//        users.add(new User("tomek","tomek123"));
//        users.add(new User("kacper","kacper123"));
//        users.add(new User("michal","michal123"));
//        users.add(new User("andrzej","andrzej123"));
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) return user;
        }
        return null;
    }
}
