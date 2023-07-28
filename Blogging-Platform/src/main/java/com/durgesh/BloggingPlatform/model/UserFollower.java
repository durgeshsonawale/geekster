package com.durgesh.BloggingPlatform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class UserFollower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userFollowerId;

    @ManyToOne
    @JoinColumn(name = "fk_owner_id")
    private User owner;

    @ManyToOne
    @JoinColumn(name = "fk_followed_id")
    private User followedUser;
}
