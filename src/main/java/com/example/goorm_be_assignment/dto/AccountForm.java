package com.example.goorm_be_assignment.dto;

import com.example.goorm_be_assignment.entity.Account;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccountForm {
    String name;
    String id;
    String pw;
    LocalDate birth;
    LocalTime createAt;
    String email;
    Integer role;

    public Account toEntity() {
        return new Account(name,id,pw,birth,createAt,email,role);
    }
}
