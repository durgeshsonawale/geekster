package com.durgesh.UniversityManagement.service;

import com.durgesh.UniversityManagement.model.Student;
import com.durgesh.UniversityManagement.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    //add
    public String createStudent(Student student){
        studentRepo.save(student);
        return "student added !!";
    }
    //update
    public String updateStudent(int id,String name){
        Student student=studentRepo.findById(id).get();
        student.setFirstName(name);
        studentRepo.save(student);
        return "student updated !!";
    }
    //delete
    public String deleteStudent(int id){
        studentRepo.deleteById(id);
        return "student deleted !!";
    }

    public List<Student> getAll(){
        return studentRepo.findAll();
    }

    public Student getById(int id){
        return studentRepo.findById(id).get();
    }
}
