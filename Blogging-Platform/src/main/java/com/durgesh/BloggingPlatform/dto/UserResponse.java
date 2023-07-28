package com.durgesh.BloggingPlatform.dto;

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
public class UserResponse {
    private Integer userId;
    private String email;
    private String userHandle;
    private String userBio;
}
