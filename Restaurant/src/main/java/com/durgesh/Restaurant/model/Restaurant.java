package com.durgesh.Restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    //restaurant name, restaurant address, number, specialty, total staffs ,Add a few more relevant variables
    private String name;
    private String address;
    private String phoneNumber;
    private String speciality;
    private Integer totalStaff;
    private Integer id;

}
