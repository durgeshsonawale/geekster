package com.durgesh.email_address.service;

import com.durgesh.email_address.dao.AddressDao;
import com.durgesh.email_address.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressService {
    @Autowired
    private AddressDao addressDao;
    public ResponseEntity<List<Address>> getAllAddress() {
        return new ResponseEntity<>(addressDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Address> getAddressById(int id) {
        return new ResponseEntity<>(addressDao.findById(id).get(),HttpStatus.OK);
    }

    public ResponseEntity<String> createAddress(Address address) {
        addressDao.save(address);
        String s="created succesfully";
        return new ResponseEntity<>(s,HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteAddressById(int id) {
        addressDao.deleteById(id);
        String s="deleted succesfully";
        return new ResponseEntity<>(s,HttpStatus.ACCEPTED);

    }

    public ResponseEntity<String> updateAddressById(int id,String city) {
        Address address=addressDao.findById(id).get();
        address.setCity(city);
        String s="updated succesfully";
        return new ResponseEntity<>(s,HttpStatus.ACCEPTED);

    }
}
