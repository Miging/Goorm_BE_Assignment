package com.example.goorm_be_assignment.api;

import com.example.goorm_be_assignment.dto.AccountForm;
import com.example.goorm_be_assignment.entity.Account;
import com.example.goorm_be_assignment.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AccountApiContorller {

    @Autowired
    private AccountService accountService;

    @PostMapping ("/users/signup")
    public ResponseEntity<Account> create(@RequestBody AccountForm dto){
        Account created= accountService.create(dto);
        return (created!=null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping ("/users/login")
    public ResponseEntity<Account> login(@RequestBody AccountForm dto){
        Account userData= accountService.login(dto.getId(),dto.getPw());
        return (userData!=null) ?
                ResponseEntity.status(HttpStatus.OK).body(userData) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


}
