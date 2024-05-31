package com.example.practice24.Controller;

import com.example.practice24.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRepo userRepo;
    @GetMapping("/user")
    public String getUsers(){
        return userRepo.findAll().toString();
    }
}
