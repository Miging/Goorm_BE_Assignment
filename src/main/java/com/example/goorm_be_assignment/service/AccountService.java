package com.example.goorm_be_assignment.service;

import com.example.goorm_be_assignment.dto.AccountForm;
import com.example.goorm_be_assignment.entity.Account;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.goorm_be_assignment.repository.AccountRepository;

import java.util.Date;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    public Account create(AccountForm form){
        //먼저
        Account entity=form.toEntity();
        return accountRepository.save(entity);
    }
    public Account login(String id, String pw){
        return accountRepository.findByIdAndPw(id, pw).orElse(null);
    }

    public String generateToken(Account account) {
        long expirationTime = 86400000; // 예: 1일
        String secretKey = "yourSecretKey";

        return Jwts.builder()
                .setSubject(account.getId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }
}
