package org.example;

import java.util.Collection;

public class UserRepository {
    private Collection <User> users;
    private static UserRepository instance;
    public static UserRepository getInstance(){
        if (instance == null){
            instance = new UserRepository();
        }
        return instance;
    }

    public Collection<User> getUsers() {
        return users;
    }
    public User getUser(String login){
        for (User user: users){
            if (user.getLogin().equals(login)) return user;
        }
        return null;
    }
}
