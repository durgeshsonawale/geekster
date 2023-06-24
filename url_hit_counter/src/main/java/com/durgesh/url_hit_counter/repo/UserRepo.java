package com.durgesh.url_hit_counter.repo;

import com.durgesh.url_hit_counter.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo {
   private List<UserInfo> li=new ArrayList<>();
   public List<UserInfo> getAll(){
        return li;
    }

    public void add(String s){
       li.add(new UserInfo(s));
    }

}
