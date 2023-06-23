package com.durgesh.usermanagement.service;

import com.durgesh.usermanagement.entity.User;
import com.durgesh.usermanagement.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private UserRepo userRepo;

    public List<User> getAlll(){
        return userRepo.getRepo();
    }

    public String addUserr(User user) {
        userRepo.getRepo().add(user);
        return "product has been added..";
    }

    public User getuserById(int b) {
        Iterator<User> i=userRepo.getRepo().iterator();
        while(i.hasNext()){
            User u=i.next();
            if(u.getUserId().equals(b)){
                return u;
            }
        }
        return null;
    }

    public String deleteuserById(int b) {
        Iterator<User> i=userRepo.getRepo().iterator();
        while(i.hasNext()){
            User u=i.next();
            if(u.getUserId().equals(b)){
                getAlll().remove(u);
                return "Deleted";
            }
        }
        return "id not found ";
    }

    public String updateNameById(int id, String name) {
        User u=getuserById(id);
        if(u !=null){
            u.setName(name);
            return "name updated";
        }
        else {
            return "id not found";
        }
    }
}
