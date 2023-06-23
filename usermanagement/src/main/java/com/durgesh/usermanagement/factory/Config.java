package com.durgesh.usermanagement.factory;

import com.durgesh.usermanagement.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {
    @Bean

    public List<User> getList(){
        return new ArrayList<>();
}}
