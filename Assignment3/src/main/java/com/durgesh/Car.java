package com.durgesh;

import org.springframework.stereotype.Component;

@Component
public class Car {

    private String name="WagonR";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
