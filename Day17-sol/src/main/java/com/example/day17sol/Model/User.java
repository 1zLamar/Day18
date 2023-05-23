package com.example.day17sol.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name shouldn't be null")
    @Size(min=5)
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @NotEmpty(message = "username shouldn't be null ")
    @Size(min=5)
    @Column(columnDefinition = "varchar(20) not null unique")
    private String username;
    @NotEmpty(message = "password shouldn't be null")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;
    @NotEmpty(message = "email shouldn't be null")
    @Email
    @Column(columnDefinition = "varchar(50) not null unique")
    private String email;
    @NotEmpty(message = "role shouldn't be null")
    @Column(columnDefinition = "varchar(20) not null check(role= 'user' or role='admin')")
    private String role;
    @NotNull(message = "age shouldn't be null")
    @Column(columnDefinition = "int not null")
    private int age;


}
