package com.durgesh.TODO_Application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.security.DenyAll;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String firstName;
    private String password;
    private String role;
    @JsonIgnore
    @OneToMany(mappedBy = "user")

    private List<ToDo> listToDo;
}
