package com.example.ApiiCollabdev.Service.auth;

import com.example.ApiiCollabdev.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthenticationUserRequest {

    private String email;
    private String password;
    private Role role;
}
