package com.example.casedeneme.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Table(name="users")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotBlank(message = "Name is mandatory")
    @Column(name="first_name")
    private String firstName;

    @NotBlank(message = "Name is mandatory")
    @Column(name="last_name")
    private String lastName;


    @NotBlank(message = "Name is mandatory")
    @Column(name="email")
    private String email;

}
