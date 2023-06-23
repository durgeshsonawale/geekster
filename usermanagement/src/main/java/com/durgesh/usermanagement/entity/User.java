package com.durgesh.usermanagement.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {

    //Create a Spring Project that is a User management system
    //The user will have the following attribute
    //UserId
    //Name
    //UserName
    //Address
    //Phone Number

    @NotNull
    private Integer userId;
    private String name;
    private String userName;
    private String address;
    private String phoneNumber;


}
