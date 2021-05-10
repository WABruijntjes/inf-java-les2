package nl.inholland.infjavales2.service;

import nl.inholland.infjavales2.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public UserService(){
        users.add(new User(1,"kees", "welkom123", "User"));
        users.add(new User(2,"jan", "welkom123", "User"));
        users.add(new User(3,"ann", "welkom123", "User"));
    }

    public List<User> getAllUsers(){
        return users;
    }
}
