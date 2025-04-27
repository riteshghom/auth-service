package com.homedecorhub.authservice.service;

import com.homedecorhub.authservice.model.User;
import com.homedecorhub.authservice.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public User register(User user) {
        return authRepository.save(user);
       
    }

    public Optional<User> login(String email, Object object) {
        Optional<User> userOpt = authRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getPassword().equals(object)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
