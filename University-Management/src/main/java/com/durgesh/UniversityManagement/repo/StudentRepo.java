package com.durgesh.UniversityManagement.repo;

import com.durgesh.UniversityManagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
