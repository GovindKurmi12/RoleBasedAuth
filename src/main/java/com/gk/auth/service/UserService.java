package com.gk.auth.service;

import com.gk.auth.jwt.JwtService;
import com.gk.auth.model.LoginRequest;
import com.gk.auth.model.User;
import com.gk.auth.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public String loginUser(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new
                UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return jwtService.generateToken(loginRequest.getUsername());
        } else {
            throw new RuntimeException("Authentication");
        }
    }
}
