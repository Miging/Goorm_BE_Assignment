package com.example.goorm_be_assignment.dto;

import com.example.goorm_be_assignment.entity.Account;
import com.example.goorm_be_assignment.model.Role;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AccountForm {
    String name;
    String id;
    String pw;
    LocalDate birth;
    LocalDateTime createAt;
    String email;
    Boolean isAdmin;

    public Account toEntity() {
        return new Account(id,name,pw,birth,createAt,email,isAdmin?Role.ROLE_ADMIN:Role.ROLE_USER);
    }

}
