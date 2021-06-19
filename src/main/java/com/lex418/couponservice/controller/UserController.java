package com.lex418.couponservice.controller;

import com.lex418.couponservice.model.User;
import com.lex418.couponservice.repo.UserRepo;
import com.lex418.couponservice.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/showReg")
    public String showRegisterUser(){
        return "registerUser";
    }

    @PostMapping("/registerUser")
    public String register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return "login";
    }

    @Autowired
    private SecurityService securityService;

    @GetMapping("/")
    public String showLoginPage(){
        return "login";
    }


    @PostMapping("/login")
    public String login(String email, String password){
        boolean loginResponse = securityService.login(email,password);
        if(loginResponse)
            return "index";
        else
            return "login";
    }
}
