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
import com.crm.app.entity.Utilisateur;
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
import com.crm.app.repository.UtilisateurRepository;
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
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;

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
	public List<QuestionStage1> findUserQuestionsStage1() {
		return questionStage1Repository.findAllByValidatorSideNumberNotOrderByRankAsc(2);
	}

	@Override
	public List<QuestionStage2> findUserQuestionsStage2() {
		return questionStage2Repository.findAllByValidatorSideNumberNotOrderByRankAsc(2);
	}

	@Override
	public List<QuestionStage3> findUserQuestionsStage3() {
		return questionStage3Repository.findAllByValidatorSideNumberNotOrderByRankAsc(2);
	}

	@Override
	public List<QuestionStage4> findUserQuestionsStage4() {
		return questionStage4Repository.findAllByValidatorSideNumberNotOrderByRankAsc(2);
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
	public List<QuestionStage2> findUserQuestionsStage2ByCompany(Company company) {
		List<QuestionStage1> questionsWithPriority = questionStage1Repository.findAllByPrioritySectorNumberNotNull();
		List<Long> sectorIdList = questionsWithPriority
				.stream()
				.map(q -> q.getAnswerStage1ByCompanyId(company.getId()))
				.map(a -> a.getValue())
				.map(s -> StaticUtils.parseLong(s))
				.collect(Collectors.toList());
		
		return questionStage2Repository.findAllByValidatorSideNumberNotAndSecteur_IdInOrderByRankAsc(2, sectorIdList);
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
	public void saveAllAnswers(Company company, Map<String, String> datas) throws RuntimeException {
		if(datas == null)
			throw new RuntimeException("datas is required");
		
		String userLogin = StaticUtils.getConnectedUserLogin();
		if(userLogin == null)
			throw new RuntimeException("no user logged in");
		
		Utilisateur user = utilisateurRepository.findByLogin(userLogin);
		if(user == null)
			throw new RuntimeException("user not found");
		
		List<AnswerStage1> toSave1 = new ArrayList<>();
		List<AnswerStage2> toSave2 = new ArrayList<>();
		List<AnswerStage3> toSave3 = new ArrayList<>();
		List<AnswerStage4> toSave4 = new ArrayList<>();
		int questionStage = 0;
		for(Map.Entry<String, String> entry : datas.entrySet()) {
			String[] nameList = entry.getKey().split("-");
			String value = entry.getValue();
			if(nameList.length == 2 && value != null && !value.isEmpty()) {
				Long questionId = StaticUtils.parseLong(nameList[1]);
				if(questionId == null || questionId <= 0L)
					throw new RuntimeException("incorrect questionId");
				
				switch (nameList[0]) {
					case "question1":
						questionStage = 1;
						QuestionStage1 questionStage1 = this.findQuestionStage1ById(questionId);
						if(questionStage1 == null)
							throw new RuntimeException("question not found");
						
						AnswerStage1 answer1 = questionStage1.getAnswerStage1ByCompanyId(company.getId());
						if(answer1 == null) {
							answer1 = new AnswerStage1();
							answer1.setCompany(company);
							answer1.setQuestionstage1(questionStage1);
						}
						
						// Check priority values
						if(questionStage1.getPrioritySectorNumber() != null) {
							Long sectorId = StaticUtils.parseLong(value);
							if(sectorId == null || sectorId <= 0L)
								throw new RuntimeException("incorrect priority");
							
							Secteur sector = secteurRepository.findById(sectorId).orElse(null);
							if(sector == null)
								throw new RuntimeException("priority not found");
						}
						
						answer1.setValue(value);
						answer1.setEditorUser(user);
						toSave1.add(answer1);
						break;
						
					case "question2":
						questionStage = 2;
						QuestionStage2 questionStage2 = this.findQuestionStage2ById(questionId);
						if(questionStage2 == null)
							throw new RuntimeException("question not found");
						
						AnswerStage2 answer2 = questionStage2.getAnswerStage2ByCompanyId(company.getId());
						if(answer2 == null) {
							answer2 = new AnswerStage2();
							answer2.setCompany(company);
							answer2.setQuestionstage2(questionStage2);
						}
						
						answer2.setValue(value);
						answer2.setEditorUser(user);
						toSave2.add(answer2);
						break;
						
					case "question3":
						questionStage = 3;
						QuestionStage3 questionStage3 = this.findQuestionStage3ById(questionId);
						if(questionStage3 == null)
							throw new RuntimeException("question not found");
						
						AnswerStage3 answer3 = questionStage3.getAnswerStage3ByCompanyId(company.getId());
						if(answer3 == null) {
							answer3 = new AnswerStage3();
							answer3.setCompany(company);
							answer3.setQuestionstage3(questionStage3);
						}
						
						answer3.setValue(value);
						answer3.setEditorUser(user);
						toSave3.add(answer3);
						break;
						
					case "question4":
						questionStage = 4;
						QuestionStage4 questionStage4 = this.findQuestionStage4ById(questionId);
						if(questionStage4 == null)
							throw new RuntimeException("question not found");
						
						AnswerStage4 answer4 = questionStage4.getAnswerStage4ByCompanyId(company.getId());
						if(answer4 == null) {
							answer4 = new AnswerStage4();
							answer4.setCompany(company);
							answer4.setQuestionstage4(questionStage4);
						}
						
						answer4.setValue(value);
						answer4.setEditorUser(user);
						toSave4.add(answer4);
						break;
	
					default:
						throw new RuntimeException("invalid question");
				}
			}
		}
		
		switch (questionStage) {
			case 1:
				List<AnswerStage1> saved1 = answerStage1Repository.saveAll(toSave1);
				if(saved1 == null || saved1.size() != toSave1.size())
					throw new RuntimeException("answers not saved");
				
				break;
				
			case 2:
				List<AnswerStage2> saved2 = answerStage2Repository.saveAll(toSave2);
				if(saved2 == null || saved2.size() != toSave2.size())
					throw new RuntimeException("answers not saved");
				
				break;
				
			case 3:
				List<AnswerStage3> saved3 = answerStage3Repository.saveAll(toSave3);
				if(saved3 == null || saved3.size() != toSave3.size())
					throw new RuntimeException("answers not saved");
				
				break;
				
			case 4:
				List<AnswerStage4> saved4 = answerStage4Repository.saveAll(toSave4);
				if(saved4 == null || saved4.size() != toSave4.size())
					throw new RuntimeException("answers not saved");
				
				break;
	
			default:
				throw new RuntimeException("invalid question");
		}
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
