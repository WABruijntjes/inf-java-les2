package nl.inholland.infjavales2.security;

import nl.inholland.infjavales2.model.User;
import nl.inholland.infjavales2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRep;

    @Override
    public UserDetails loadUserByUsername(String u) throws UsernameNotFoundException {

        User user = userRep.findByUsername(u); //"User" is the User class from own project

        if(user == null)
            throw new UsernameNotFoundException("User "+ u + " not found");

        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(u)
                .password(user.getPassword())
                .authorities(user.getRoles())
                .accountExpired(false) //Declare ACCOUNT is not EXPIRED
                .accountLocked(false)  //Declare ACCOUNT is not LOCKED
                .credentialsExpired(false)  //Declare CREDENTIALS are not EXPIRED
                .disabled(false)  //Declare ACCOUNT is not DISABLED
                .build();

        return userDetails;
    }
}
