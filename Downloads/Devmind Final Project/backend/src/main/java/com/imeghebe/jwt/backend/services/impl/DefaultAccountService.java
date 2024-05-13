package com.imeghebe.jwt.backend.services.impl;

import com.imeghebe.jwt.backend.entites.Account;
import com.imeghebe.jwt.backend.exceptions.AppException;
import com.imeghebe.jwt.backend.repositories.AccountRepository;
import com.imeghebe.jwt.backend.services.AccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultAccountService implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username).orElseThrow(() -> new AppException("User not found!", HttpStatus.BAD_REQUEST));
    }
}
