package com.example.goorm_be_assignment.repository;

import com.example.goorm_be_assignment.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String> {

}
