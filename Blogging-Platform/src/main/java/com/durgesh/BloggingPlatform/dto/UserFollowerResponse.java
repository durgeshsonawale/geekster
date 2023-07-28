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

public class UserFollowerResponse {
    private Integer followedId;
    private String followedUserHandle;
    private String followedEmail;
}
