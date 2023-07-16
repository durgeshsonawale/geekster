package com.durgesh.UniversityManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    @Pattern(regexp = "^[A-Z].*$", message = "First letter should be capitalized")
    private String firstName;
    private String lastName;
    @Max(25)
    @Min(18)
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Department department;
}
