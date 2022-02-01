package com.crm.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.app.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
