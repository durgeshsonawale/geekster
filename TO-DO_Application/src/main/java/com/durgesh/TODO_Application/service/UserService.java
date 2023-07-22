package com.durgesh.TODO_Application.service;

import com.durgesh.TODO_Application.model.ToDo;
import com.durgesh.TODO_Application.model.User;
import com.durgesh.TODO_Application.repo.ToDoRepo;
import com.durgesh.TODO_Application.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    //create user
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepo userRepo;
    public String create(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return "user created";

    }

    public List<User> getAll() {
        return userRepo.findAll();
    }
}
