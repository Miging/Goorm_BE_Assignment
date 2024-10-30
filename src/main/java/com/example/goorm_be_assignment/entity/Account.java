package com.example.goorm_be_assignment.entity;

import com.example.goorm_be_assignment.model.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Account {
    @Id
    String id;
    @Column
    String name;
    @Column
    String pw;
    @Column
    LocalDate birth;
    @CreatedDate
    @Column(updatable = false)
    LocalDateTime createAt;
    @Column
    String email;
    @Enumerated(EnumType.STRING)
    @Column
    Role role;

}
