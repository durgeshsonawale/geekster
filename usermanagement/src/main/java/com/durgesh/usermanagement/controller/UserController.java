package com.durgesh.usermanagement.controller;

import com.durgesh.usermanagement.entity.User;
import com.durgesh.usermanagement.service.Service;
import com.durgesh.usermanagement.service.UrlHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    //endpoint to be provided
    //addUser
    //getUser/{userid}
    //getAllUser
    //updateUserInfo
    //deleteUser

    @Autowired
    private Service service;
    @Autowired
    UrlHitService serv;

    @GetMapping("/users")
    public List<User> getAll(){
        return service.getAlll();
    }
    @PostMapping("/user")
    public String addUser(@RequestBody User user){
        return service.addUserr(user);
    }
    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable int id){
        return service.deleteuserById(id);
    }


    @GetMapping("users/{b}")
    public User getUserById(@PathVariable int b){
        return service.getuserById(b);
    }

    @PutMapping("/users/name/{id}/{name}")
    public String  updateNameById(@PathVariable int id,@PathVariable String name){
        return service.updateNameById(id,name);
    }




}
