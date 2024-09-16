package com.creativefuel.login_authentication.controller;

import com.creativefuel.login_authentication.model.MyUser;
import com.creativefuel.login_authentication.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContentController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/home")
    public String handleWelcome(){
        return "home";
    }

    @GetMapping("/user/home")
    public String handleLogin(){
        return "user/home";

    }
    @GetMapping("/allUser")
    public List<MyUser> getAllUsers(){
        return userRepository.findAll();
    }

}
