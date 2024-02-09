package com.example.SchoolProject.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="student3")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String fullName;

    private String address;

    private String gender;

    private String major;

    private Long phoneNumber;

    private String email;



}
