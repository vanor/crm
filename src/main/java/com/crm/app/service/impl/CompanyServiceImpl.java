package com.crm.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.app.entity.Company;
import com.crm.app.entity.QuestionStage1;
import com.crm.app.entity.QuestionStage2;
import com.crm.app.entity.QuestionStage3;
import com.crm.app.entity.QuestionStage4;
import com.crm.app.repository.CompanyRepository;
import com.crm.app.repository.QuestionStage1Repository;
import com.crm.app.repository.QuestionStage2Repository;
import com.crm.app.repository.QuestionStage3Repository;
import com.crm.app.repository.QuestionStage4Repository;
import com.crm.app.service.CompanyService;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private QuestionStage1Repository questionStage1Repository;
	
	@Autowired
	private QuestionStage2Repository questionStage2Repository;
	
	@Autowired
	private QuestionStage3Repository questionStage3Repository;
	
	@Autowired
	private QuestionStage4Repository questionStage4Repository;

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

	@Override
	public List<QuestionStage1> findAllQuestionsStage1() {
		return questionStage1Repository.findAllByOrderByRankAsc();
	}

	@Override
	public List<QuestionStage2> findAllQuestionsStage2() {
		return questionStage2Repository.findAllByOrderByRankAsc();
	}

	@Override
	public List<QuestionStage3> findAllQuestionsStage3() {
		return questionStage3Repository.findAllByOrderByRankAsc();
	}

	@Override
	public List<QuestionStage4> findAllQuestionsStage4() {
		return questionStage4Repository.findAllByOrderByRankAsc();
	}
}
