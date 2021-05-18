package nl.inholland.infjavales2.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN;

    @Override
    public String getAuthority(){
        return name(); //return one of the above described roles
    }

}
