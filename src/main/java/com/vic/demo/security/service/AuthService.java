package com.vic.demo.security.service;

import com.vic.demo.model.User;

public interface AuthService {
    User register(User userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}
