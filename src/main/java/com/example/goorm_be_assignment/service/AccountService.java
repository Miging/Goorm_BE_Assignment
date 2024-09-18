package com.example.goorm_be_assignment.service;

import com.example.goorm_be_assignment.dto.AccountForm;
import com.example.goorm_be_assignment.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.goorm_be_assignment.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    public Account create(AccountForm form){
        //먼저
        Account entity=form.toEntity();
        return accountRepository.save(entity);

    }
}
