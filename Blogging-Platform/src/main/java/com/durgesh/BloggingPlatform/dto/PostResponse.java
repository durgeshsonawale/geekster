package com.durgesh.BloggingPlatform.dto;

import com.durgesh.BloggingPlatform.model.Enum.ContentType;
import jakarta.validation.constraints.NotNull;
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

public class PostResponse {
    private Integer postId;
    private String postContent;
    private String postCaption;
    private String postLocation;
    private ContentType contentType;
    private LocalDateTime postCreatedTimeStamp;
    private String postOwnerUserHandle;
}
