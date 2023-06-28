package com.durgesh.Restaurant.factory;

import com.durgesh.Restaurant.model.Restaurant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanFactory {
    @Bean
    public List<Restaurant> get(){
        return new ArrayList<>();
    }
}
