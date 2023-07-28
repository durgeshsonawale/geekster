package com.durgesh.BloggingPlatform.repo;

import com.durgesh.BloggingPlatform.model.Enum.ContentType;
import com.durgesh.BloggingPlatform.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPostRepo extends JpaRepository<Post,Integer> {
    @Query(value = "select * from post where user_id=:userId",nativeQuery = true)
    List<Post> findAllByUserId(int userId,Pageable pageable);
    @Query(value = "select * from post where content_type=:type",nativeQuery = true)
    List<Post> findAllByContentType1(String type, Pageable pageable);
}
