package com.DemoSystem.Banking.Application.repository;

import com.DemoSystem.Banking.Application.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
