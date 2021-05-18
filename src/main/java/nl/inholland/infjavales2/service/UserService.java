package nl.inholland.infjavales2.service;

import nl.inholland.infjavales2.model.User;
import nl.inholland.infjavales2.repository.UserRepository;
import nl.inholland.infjavales2.security.JwtTokenFilter;
import nl.inholland.infjavales2.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String login(String username, String password){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            User user = userRepository.findByUsername(username);

            return tokenProvider.createToken(username, user.getRoles());
        }catch(AuthenticationException ex){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Username/password invalid");
        }
    }

    public User addUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) == null) {


            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return user;
        }
        else{
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Username already in use");
        }
    }

    public List<User> getAllUsers(){ return userRepository.findAll();}
}
