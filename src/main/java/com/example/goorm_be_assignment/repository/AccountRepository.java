package com.example.goorm_be_assignment.repository;

import com.example.goorm_be_assignment.entity.Account;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String> {

    @Query("SELECT a FROM Account a WHERE a.id = :id AND a.pw = :pw")
    Optional<Account> findByIdAndPw(String id, String pw);
}
