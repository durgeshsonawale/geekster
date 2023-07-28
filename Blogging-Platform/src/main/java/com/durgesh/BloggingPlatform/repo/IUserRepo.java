package com.durgesh.BloggingPlatform.repo;

import com.durgesh.BloggingPlatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepo extends JpaRepository<User,Integer> {
    User findFirstByEmail(String email);
}
