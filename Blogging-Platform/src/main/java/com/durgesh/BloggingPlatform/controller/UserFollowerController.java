package com.durgesh.BloggingPlatform.controller;

import com.durgesh.BloggingPlatform.dto.UserFollowerResponse;
import com.durgesh.BloggingPlatform.model.UserFollower;
import com.durgesh.BloggingPlatform.service.UserFollowerService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("userfollower")
@SecurityRequirement(name="AuthenticationToken")
public class UserFollowerController {
    @Autowired
    private UserFollowerService userFollowerService;

    //add follower
    @PostMapping("follow")
    public String followUser(@RequestBody UserFollower userFollower){
        return userFollowerService.followUser(userFollower);
    }

    //get all follower by userId
    @GetMapping("followed/{id}")
    public List<UserFollowerResponse> getAllById(@PathVariable int id){
        return userFollowerService.getAllById(id);
    }
}
