package com.durgesh.BloggingPlatform.dto;

import com.durgesh.BloggingPlatform.model.Enum.ContentType;
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
public class PostRequest {
    private Integer postId;
    private String postContent;
    private String postCaption;
    private String postLocation;
    private ContentType contentType;
    private Integer postOwnerId;
}
