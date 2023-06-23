package com.durgesh.usermanagement.repo;

import com.durgesh.usermanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo {
    @Autowired
    List<User> userList;
    public List<User>  getRepo(){
        return userList;
    }
}
