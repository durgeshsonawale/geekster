package com.durgesh.UniversityManagement.controller;

import com.durgesh.UniversityManagement.model.Student;
import com.durgesh.UniversityManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("{id}")
    public Student getById(@PathVariable int id){
        return studentService.getById(id);
    }
    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }
    @PostMapping
    public String createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
    @PutMapping("{id}/{name}")
    public String updateStudent(@PathVariable int id,@PathVariable String name){
        return studentService.updateStudent(id,name);
    }
    @DeleteMapping("{id}")
    public String deleteStudent(@PathVariable int id){
        return studentService.deleteStudent(id);
    }

}
