package com.durgesh.BloggingPlatform.controller;

import com.durgesh.BloggingPlatform.dto.UserResponse;
import com.durgesh.BloggingPlatform.model.User;
import com.durgesh.BloggingPlatform.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@SecurityRequirement(name="AuthenticationToken")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("welcome")
    public String welcome(){
        return "Welcome to my Blogging platform Api !!!!";
    }

    @PostMapping("signup")
    public String signUpUser(@RequestBody User user){
        return userService.signUp(user);
    }
    @GetMapping("{id}")
    public UserResponse getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }
}
