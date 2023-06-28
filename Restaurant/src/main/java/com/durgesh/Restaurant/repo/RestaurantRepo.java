package com.durgesh.Restaurant.repo;

import com.durgesh.Restaurant.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestaurantRepo {
    @Autowired
    List<Restaurant> list;
    public List<Restaurant> getList(){
        return list;
    }
}
