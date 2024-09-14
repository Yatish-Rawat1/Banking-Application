package com.DemoSystem.Banking.Application.service;

import com.DemoSystem.Banking.Application.dto.AccountDto;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);
    AccountDto findAccountById(Long id);
    AccountDto deposit(Long id, double amount);
    Integer StreamTest(Long id);

    }
