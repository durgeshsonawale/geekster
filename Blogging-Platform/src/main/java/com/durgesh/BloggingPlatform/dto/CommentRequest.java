package com.durgesh.BloggingPlatform.dto;

import jakarta.annotation.security.DenyAll;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class CommentRequest {
    private Integer commentId;
    private String commentBody;
    private Integer postId;
    private Integer commenterId;
}
