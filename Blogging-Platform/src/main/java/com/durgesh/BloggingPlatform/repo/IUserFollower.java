package com.durgesh.BloggingPlatform.repo;

import com.durgesh.BloggingPlatform.model.UserFollower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUserFollower extends JpaRepository<UserFollower,Integer> {
    @Query(value = "select * from user_follower where fk_owner_id=:id",nativeQuery = true)
    List<UserFollower> findByOwnerId(int id);
}
