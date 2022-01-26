package com.crm.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.app.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{
	Company findFirstByName(String name);
}
