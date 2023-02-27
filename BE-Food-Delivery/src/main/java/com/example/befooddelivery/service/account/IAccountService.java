package com.example.befooddelivery.service.account;

import com.example.befooddelivery.entity.account.Account;

import java.util.Optional;

public interface IAccountService {
    Optional<Account> findByEmail(String email);
    Boolean existsByEmail(String email);
    Account save(Account account);
}
