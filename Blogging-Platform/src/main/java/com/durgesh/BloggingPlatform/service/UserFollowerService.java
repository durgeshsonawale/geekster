package com.durgesh.BloggingPlatform.service;

import com.durgesh.BloggingPlatform.dto.UserFollowerResponse;
import com.durgesh.BloggingPlatform.model.UserFollower;
import com.durgesh.BloggingPlatform.repo.IUserFollower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserFollowerService {
    @Autowired
    private IUserFollower iUserFollower;
    @Autowired
    private UserService userService;


    public List<UserFollowerResponse> getAllById(int id) {
        List<UserFollower> list=iUserFollower.findByOwnerId(id);
        List<UserFollowerResponse> finallist=new ArrayList<>();
        for(UserFollower i:list){
            finallist.add(new UserFollowerResponse(i.getFollowedUser().getUserId(),i.getFollowedUser().getUserHandle(),
                    i.getFollowedUser().getEmail()));
        }
        return finallist;
    }

    public String followUser(UserFollower userFollower){
        if(!userService.validate(userFollower.getOwner().getUserId()))return "u can follow user through ur id only";
        iUserFollower.save(userFollower);
        return "successfully followed user";
    }
}
