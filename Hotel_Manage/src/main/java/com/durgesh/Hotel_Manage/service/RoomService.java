package com.durgesh.Hotel_Manage.service;


import org.springframework.stereotype.Service;
import com.durgesh.Hotel_Manage.model.HotelRoom;
import com.durgesh.Hotel_Manage.repo.IRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoomService {
    @Autowired
    IRoomRepo roomRepo;

    public Iterable<HotelRoom> getAllRooms() {
       return roomRepo.findAll();
    }
    public String addRoom(HotelRoom room) {
        roomRepo.save(room);
        return "added";
    }


}
