package com.durgesh.TODO_Application.controller;

import com.durgesh.TODO_Application.model.User;
import com.durgesh.TODO_Application.repo.UserRepo;
import com.durgesh.TODO_Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public String welcome(){
        return "this is welcome page";
    }


    @PostMapping
    public String addUser(@RequestBody User user){
        return userService.create(user);
    }

    @GetMapping("users")
    public List<User> getAll(){
        return userService.getAll();
    }
    @GetMapping("test")
    public String test(){
        return "testing purpose";
    }
}
