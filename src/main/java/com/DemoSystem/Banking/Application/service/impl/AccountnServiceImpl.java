package com.DemoSystem.Banking.Application.service.impl;

import com.DemoSystem.Banking.Application.dto.AccountDto;
import com.DemoSystem.Banking.Application.repository.AccountRepository;
import com.DemoSystem.Banking.Application.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountnServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountnServiceImpl(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }
    @Override
    public AccountDto createaccount(AccountDto accountDto) {
        return null;
    }
}
