package com.example.goorm_be_assignment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    String id;
    @Column
    String name;
    @Column
    String pw;
    @Column
    LocalDate birth;
    @Column
    LocalTime createAt;
    @Column
    String email;
    @Column
    Integer role;
}
