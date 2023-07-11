package com.durgesh.email_address.controller;


import com.durgesh.email_address.entity.Address;
import com.durgesh.email_address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {
    @Autowired
    private AddressService employeeService;
    @GetMapping
    public ResponseEntity<List<Address>> getAllAddress(){
        return employeeService.getAllAddress();
    }
    @GetMapping("{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable int id){
        return employeeService.getAddressById(id);
    }
    @PostMapping
    public ResponseEntity<String> createAddress(@RequestBody Address address){
        return employeeService.createAddress(address);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAddressById(@PathVariable int id){
        return employeeService.deleteAddressById(id);
    }
    @PutMapping("{id}/{city}")
    public ResponseEntity<String> updateAddressById(@PathVariable int id,@PathVariable String city){
        return employeeService.updateAddressById(id,city);
    }

}
