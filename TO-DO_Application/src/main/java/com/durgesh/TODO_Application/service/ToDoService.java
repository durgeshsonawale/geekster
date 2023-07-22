package com.durgesh.TODO_Application.service;

import com.durgesh.TODO_Application.model.ToDo;
import com.durgesh.TODO_Application.repo.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ToDoService {
    @Autowired
    private ToDoRepo toDoRepo;

    //add todo

    public String addToDo(ToDo toDo){
        toDoRepo.save(toDo);
        return "added succesfully";
    }

    public List<ToDo> getAll(int id){
        return toDoRepo.findByUserId(id);
    }

    public String toggle(int id){
        ToDo toDo=toDoRepo.findById(id).get();
        if(toDo.getStatus())toDo.setStatus(false);
        else toDo.setStatus(true);
        toDoRepo.save(toDo);
        return "Status: "+toDo.getStatus();
    }


}
