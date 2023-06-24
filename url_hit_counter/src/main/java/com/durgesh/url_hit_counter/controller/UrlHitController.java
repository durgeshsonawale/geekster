package com.durgesh.url_hit_counter.controller;

import com.durgesh.url_hit_counter.entity.UserInfo;
import com.durgesh.url_hit_counter.service.UrlHitService;
import org.apache.catalina.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/visitor-count-app")
public class UrlHitController {
    @Autowired
    UrlHitService service;

    @GetMapping("/count")
        public String getHitCount(){
            return "visitors: "+service.getHitCount();
        }


    @GetMapping("/users")
    public List<UserInfo> getAll(){
        return service.getAll();
    }
    @PostMapping("/users/name/{name}")
    public String add(@PathVariable String name){
        return service.add(name);
    }

    @GetMapping ("/username/{name}/count")
    public UserInfo getUserHitCount(@PathVariable String name){
        return service.getUserHitCount(name);
    }



}
