package com.sindhu.promotionmanager.controller;

import com.sindhu.promotionmanager.model.User;
import com.sindhu.promotionmanager.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/users/register")
    public User register(@RequestBody User user){

        return userService.registerUser(user);
    }

    @PostMapping("/users/login")
    public User login(@RequestBody User user){
        return userService.loginUser(user);
    }



}
