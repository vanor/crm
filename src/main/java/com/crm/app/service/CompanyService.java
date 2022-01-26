package com.crm.app.service;

import java.util.List;

import com.crm.app.entity.Company;

public interface CompanyService {
	Company findById(Long id);
	Company findByName(String name);
	Company save(Company company);
	List<Company> findAll();
}
