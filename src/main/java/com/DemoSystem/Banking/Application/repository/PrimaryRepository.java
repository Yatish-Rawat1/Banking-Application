package com.DemoSystem.Banking.Application.repository;

import com.DemoSystem.Banking.Application.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryRepository extends JpaRepository<Account, Long> {
    // Custom query methods (if any) go here
}
