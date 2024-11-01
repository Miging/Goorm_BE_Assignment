package com.example.goorm_be_assignment.entity;

import com.example.goorm_be_assignment.model.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

@AllArgsConstructor
public class Course {
    //- id
    //- 강좌명
    //- 강의 시간
    //- 담당 교수
    //- 정원
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private int time;
    @Column
    private String professor;
    @Column
    private int capacity;
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createAt;
    @UpdateTimestamp
    @Column()
    private LocalDateTime updateAt;
}
