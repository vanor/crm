package com.crm.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.app.entity.Company;
import com.crm.app.repository.CompanyRepository;
import com.crm.app.service.CompanyService;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Company findById(Long id) {
		return companyRepository.findById(id).orElse(null);
	}

	@Override
	public Company findByName(String name) {
		return companyRepository.findFirstByName(name);
	}

	@Override
	public Company save(Company company) {
		return companyRepository.save(company);
	}

	@Override
	public List<Company> findAll() {
		return companyRepository.findAll();
	}
}
