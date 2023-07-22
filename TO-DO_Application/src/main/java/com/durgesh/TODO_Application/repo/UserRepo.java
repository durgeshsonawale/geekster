package com.durgesh.TODO_Application.repo;

import com.durgesh.TODO_Application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepo extends JpaRepository<User,Integer> {

    User findFirstByFirstName(String username);
}
