package com.example.ApiiCollabdev.Service.auth;

public interface AuthenticationStrategy {

    Boolean authenticate(String email, String password);
}
