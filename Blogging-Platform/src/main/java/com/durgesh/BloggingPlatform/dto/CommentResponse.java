package com.durgesh.BloggingPlatform.dto;

import com.durgesh.BloggingPlatform.model.Post;
import com.durgesh.BloggingPlatform.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class CommentResponse {
    private Integer commentId;
    private String commentBody;
    private LocalDateTime commentCreationTimeStamp;
    private Integer postId;

    private String postOwnerUserHandle;
    private Integer commenterId;

    private String commenterUserHandle;




}
