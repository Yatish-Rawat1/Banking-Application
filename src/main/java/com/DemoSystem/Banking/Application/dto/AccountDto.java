package com.DemoSystem.Banking.Application.dto;

import lombok.Data;

@Data
// auto generate getter setter constructor
public class AccountDto {
    private Long id;
    private String accountHolderName;
    private double balance;
}
