package com.durgesh.UniversityManagement.controller;

import com.durgesh.UniversityManagement.model.Event;
import com.durgesh.UniversityManagement.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("event")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping
    public String createEvent(@RequestBody Event event){
        return eventService.createEvent(event);
    }
    @PutMapping("{id}/{date}")
    public String updateEvent(@PathVariable int id, @PathVariable LocalDate date){
        return eventService.updateEvent(id,date);
    }
    @DeleteMapping("{id}")
    public String deleteEvent(@PathVariable int id){
        return eventService.deleteEvent(id);
    }
}
