package com.esercizio07.esercizio07;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

}