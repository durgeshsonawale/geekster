package com.durgesh.Restaurant.controller;

import com.durgesh.Restaurant.model.Restaurant;
import com.durgesh.Restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {
    /*
 -get Restaurant by id using GetMapping.
-get all Reataurant using  GetMapping
-Add some Restaurant to Restaurant lists using PostMapping
-update Restaurant information like Specialty.
-delete Restaurant from the list.
*/

    @Autowired
    RestaurantService service;

    @GetMapping("restaurants")
    private List<Restaurant> getAll(){
        return service.getAll();
    }
    @GetMapping("restaurants/{id}")
    private Restaurant getById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping("restaurants")
    private String addRestaurants(@RequestBody List<Restaurant> restaurants){
        return service.addRestaurants(restaurants);
    }

    @PutMapping("restaurants/{id}/{special}")
    private String updateById(@PathVariable int id, @PathVariable String special){
        return service.updateById(id,special);
    }

    @DeleteMapping("restaurants/{id}")
    private String deleteById(@PathVariable int id){
        return service.deleteById(id);
    }


}
