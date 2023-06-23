package com.durgesh.usermanagement.controller;


import com.durgesh.usermanagement.service.UrlHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/visitor-count-app")
public class UrlHitController {
    @Autowired
    UrlHitService service;
    @GetMapping("/count")
        public int getHitCount(){
            return service.getHitCount();
        }




}
