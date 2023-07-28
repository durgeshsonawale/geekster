package com.durgesh.BloggingPlatform.repo;

import com.durgesh.BloggingPlatform.model.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IComment extends JpaRepository<Comment,Integer> {
    @Query(value = "SELECT * FROM COMMENT WHERE fk_comment_post_id =:postId",nativeQuery = true)
    List<Comment> findAllByPostId(int postId, Pageable pageable);
}
