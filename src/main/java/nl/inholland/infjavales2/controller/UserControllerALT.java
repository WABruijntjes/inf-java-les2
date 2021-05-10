package nl.inholland.infjavales2.controller;

import nl.inholland.infjavales2.model.User;
import nl.inholland.infjavales2.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users2")
public class UserControllerALT {

    private UserService uService;

    public UserControllerALT(UserService uService) {
        this.uService = uService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return uService.getAllUsers();
    }

}
