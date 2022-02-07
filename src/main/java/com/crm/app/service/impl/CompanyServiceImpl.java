package com.crm.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.app.entity.AnswerStage1;
import com.crm.app.entity.AnswerStage2;
import com.crm.app.entity.AnswerStage3;
import com.crm.app.entity.AnswerStage4;
import com.crm.app.entity.Company;
import com.crm.app.entity.QuestionStage1;
import com.crm.app.entity.QuestionStage2;
import com.crm.app.entity.QuestionStage3;
import com.crm.app.entity.QuestionStage4;
import com.crm.app.entity.Secteur;
import com.crm.app.repository.AnswerStage1Repository;
import com.crm.app.repository.AnswerStage2Repository;
import com.crm.app.repository.AnswerStage3Repository;
import com.crm.app.repository.AnswerStage4Repository;
import com.crm.app.repository.CompanyRepository;
import com.crm.app.repository.QuestionStage1Repository;
import com.crm.app.repository.QuestionStage2Repository;
import com.crm.app.repository.QuestionStage3Repository;
import com.crm.app.repository.QuestionStage4Repository;
import com.crm.app.repository.SecteurRepository;
import com.crm.app.service.CompanyService;
import com.crm.app.utils.StaticUtils;

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
	
	@Autowired
	private AnswerStage1Repository answerStage1Repository;
	
	@Autowired
	private AnswerStage2Repository answerStage2Repository;
	
	@Autowired
	private AnswerStage3Repository answerStage3Repository;
	
	@Autowired
	private AnswerStage4Repository answerStage4Repository;
	
	@Autowired
	private SecteurRepository secteurRepository;

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
	public QuestionStage1 findQuestionStage1ById(Long id) {
		return questionStage1Repository.findById(id).orElse(null);
	}

	@Override
	public QuestionStage2 findQuestionStage2ById(Long id) {
		return questionStage2Repository.findById(id).orElse(null);
	}

	@Override
	public QuestionStage3 findQuestionStage3ById(Long id) {
		return questionStage3Repository.findById(id).orElse(null);
	}

	@Override
	public QuestionStage4 findQuestionStage4ById(Long id) {
		return questionStage4Repository.findById(id).orElse(null);
	}
	
	@Override
	public List<Secteur> findAllSectors() {
		return secteurRepository.findAll();
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
	
	@Override
	public List<QuestionStage2> findAllQuestionsStage2ByCompany(Company company) {
		List<QuestionStage1> questionsWithPriority = questionStage1Repository.findAllByPrioritySectorNumberNotNull();
		List<Long> sectorIdList = questionsWithPriority
				.stream()
				.map(q -> q.getAnswerStage1ByCompanyId(company.getId()))
				.map(a -> a.getValue())
				.map(s -> StaticUtils.parseLong(s))
				.collect(Collectors.toList());
		
		return questionStage2Repository.findAllBySecteur_IdInOrderByRankAsc(sectorIdList);
	}

	@Override
	public List<AnswerStage1> findAllAnswersStage1ByCompany(Company company) {
		return null;
	}

	@Override
	public List<AnswerStage2> findAllAnswersStage2ByCompany(Company company) {
		return null;
	}

	@Override
	public List<AnswerStage3> findAllAnswersStage3ByCompany(Company company) {
		return null;
	}

	@Override
	public List<AnswerStage4> findAllAnswersStage4ByCompany(Company company) {
		return null;
	}

	@Override
	public List<AnswerStage1> saveAllAnswersStage1(Company company, Map<String, String> datas) throws RuntimeException {
		if(datas == null)
			throw new RuntimeException("datas is required");
		
		List<AnswerStage1> toSave = new ArrayList<>();
		for(Map.Entry<String, String> entry : datas.entrySet()) {
			String[] nameList = entry.getKey().split("-");
			if(nameList.length == 2) {
				Long questionId = StaticUtils.parseLong(nameList[1]);
				if(questionId == null)
					throw new RuntimeException("incorrect questionId");
				
				QuestionStage1 questionStage1 = this.findQuestionStage1ById(questionId);
				if(questionStage1 == null)
					throw new RuntimeException("question not found");
					
				AnswerStage1 answer = questionStage1.getAnswerStage1ByCompanyId(company.getId());
				if(answer == null) {
					answer = new AnswerStage1();
					answer.setCompany(company);
					answer.setQuestionstage1(questionStage1);
				}
				
				// Check priority values
				if(questionStage1.getPrioritySectorNumber() != null) {
					Long sectorId = StaticUtils.parseLong(entry.getValue());
					if(sectorId == null || sectorId <= 0L)
						throw new RuntimeException("incorrect priority");
					
					Secteur sector = secteurRepository.findById(sectorId).orElse(null);
					if(sector == null)
						throw new RuntimeException("priority not found");
				}
				
				answer.setValue(entry.getValue());
				toSave.add(answer);
			}
		}
		
		List<AnswerStage1> saved = answerStage1Repository.saveAll(toSave);
		if(saved == null || saved.size() != toSave.size())
			throw new RuntimeException("answers not saved");
		
		return saved;
	}

	@Override
	public boolean isStage1CompletedByCompany(Company company) {
		// For instance only check if the three priority are set.
		List<QuestionStage1> questionsWithPriority = questionStage1Repository.findAllByPrioritySectorNumberNotNull();
		for(QuestionStage1 question : questionsWithPriority) {
			AnswerStage1 answerCompany = question.getAnswerStage1ByCompanyId(company.getId());
			if(answerCompany == null || answerCompany.getValue() == null || answerCompany.getValue().isEmpty())
				return false;
			
			Long sectorId = StaticUtils.parseLong(answerCompany.getValue());
			if(sectorId == null || sectorId <= 0L)
				return false;
			
			Secteur sector = secteurRepository.findById(sectorId).orElse(null);
			if(sector == null)
				return false;
		}
		
		return true;
	}
}
