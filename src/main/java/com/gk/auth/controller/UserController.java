package com.gk.auth.controller;

import com.gk.auth.model.LoginRequest;
import com.gk.auth.model.User;
import com.gk.auth.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return userService.loginUser(loginRequest);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
