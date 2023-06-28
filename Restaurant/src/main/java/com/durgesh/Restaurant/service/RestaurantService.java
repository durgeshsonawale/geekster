package com.durgesh.Restaurant.service;

import com.durgesh.Restaurant.model.Restaurant;
import com.durgesh.Restaurant.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepo repo;

    public List<Restaurant> getAll() {
        return repo.getList();
    }

    public Restaurant getById(int id) {
        for(Restaurant r:repo.getList()){
            if(r.getId().equals(id)){
                return r;
            }
        }
        return null;
    }

    public String addRestaurants(List<Restaurant> restaurants) {
        repo.getList().addAll(restaurants);
        return "All the restaurants have been added..";
    }

    public String updateById(int id, String special) {
        for(Restaurant r:repo.getList()){
            if(r.getId().equals(id)){
                r.setSpeciality(special);
                return "updated speciality is "+special;
            }
        }
        return "no restaurant found";

    }

    public String deleteById(int id) {
        for(Restaurant r:repo.getList()){
            if(r.getId().equals(id)){
                repo.getList().remove(r);
                return "restaurant has been deleted";
            }
        }
        return "no restaurant found";
    }
}
