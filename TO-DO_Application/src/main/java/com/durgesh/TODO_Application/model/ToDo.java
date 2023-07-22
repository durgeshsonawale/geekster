package com.durgesh.TODO_Application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer toDoId;
    private String description;
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

}
