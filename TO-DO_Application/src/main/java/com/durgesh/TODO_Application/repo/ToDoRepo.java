package com.durgesh.TODO_Application.repo;

import com.durgesh.TODO_Application.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ToDoRepo extends JpaRepository<ToDo,Integer> {
    @Query(nativeQuery = true,value = "select * from todo where fk_user_id=:id")
    List<ToDo> findByUserId(int id);
}
