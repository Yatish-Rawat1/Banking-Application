package com.DemoSystem.Banking.Application.service;

import com.DemoSystem.Banking.Application.dto.AccountDto;
import com.DemoSystem.Banking.Application.entity.Account;

public interface AccountService {

    AccountDto createaccount(AccountDto accountDto);
}
