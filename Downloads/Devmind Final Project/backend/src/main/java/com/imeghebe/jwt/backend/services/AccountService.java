package com.imeghebe.jwt.backend.services;

import com.imeghebe.jwt.backend.entites.Account;

public interface AccountService {

    Account findByUsername(String username);
}
