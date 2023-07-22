package com.durgesh.TODO_Application.controller;

import com.durgesh.TODO_Application.model.ToDo;
import com.durgesh.TODO_Application.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todo")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping("todos/{id}")
    public List<ToDo> getAll(@PathVariable int id){
        return toDoService.getAll(id);
    }
    @PutMapping("toggle/{id}")
    public String toggle(int id){
        return toDoService.toggle(id);
    }
    @PostMapping
    public String Add(@RequestBody ToDo toDo){
        return toDoService.addToDo(toDo);
    }
}
