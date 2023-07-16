package com.durgesh.UniversityManagement.service;

import com.durgesh.UniversityManagement.model.Event;
import com.durgesh.UniversityManagement.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EventService {
    @Autowired
    private EventRepo eventRepo;

    //ADD
    public String createEvent(Event event){
        eventRepo.save(event);
        return "event added !!";
    }
    //UPDATE
    public String updateEvent(int id,LocalDate localDate){
        Event event=eventRepo.findById(id).get();
        event.setEventDate(localDate);
        eventRepo.save(event);
        return "event updated !!";
    }
    //DELETE
    public String deleteEvent(int id){
        eventRepo.deleteById(id);
        return "event deleted !!";
    }


}
