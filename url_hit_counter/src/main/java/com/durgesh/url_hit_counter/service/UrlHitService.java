package com.durgesh.url_hit_counter.service;

import com.durgesh.url_hit_counter.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.durgesh.url_hit_counter.repo.UserRepo;

import java.util.Iterator;
import java.util.List;

@Service
public class UrlHitService {
    @Autowired
    UserRepo repo;

    private int hitCount=0;

    public int getHitCount() {
        return ++hitCount;
    }
    public String add(String  user){

        repo.add(user);
        return "new user added";
    }
    public List<UserInfo> getAll(){
        return repo.getAll();
    }

    public UserInfo getUserHitCount(String name){
        Iterator<UserInfo> i=repo.getAll().iterator();
        while(i.hasNext()){
            UserInfo u=i.next();
            if(u.getName().equals(name)){
                u.setCount(u.getCount()+1);
                return u;
            }
        }
        return null;
    }
}
