package com.example.ApiiCollabdev.Service;

import com.example.ApiiCollabdev.Service.auth.AuthenticationStrategy;
import com.example.ApiiCollabdev.entities.Contributeur;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Service
public class AuthenticationService {

    private AuthenticationStrategy user;

    public AuthenticationService() {
        this.user = null;
    }

    public Boolean authenticate(
            String email,
            String password
    ) {
        return this.user.authenticate(email, password);
    }
}
