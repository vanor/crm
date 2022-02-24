package com.crm.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.app.dto.ProgressDto;
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
	public Secteur findSecteurById(Long id) {
		return secteurRepository.findById(id).orElse(null);
	}
	
	@Override
	public List<Secteur> findAllSectors() {
		return secteurRepository.findAll();
	}
	
	@Override
	public List<Secteur> findSectorsByCompany(Company company) {
		List<QuestionStage1> questionsWithPriority = questionStage1Repository.findAllByPrioritySectorNumberNotNullOrderByPrioritySectorNumberAsc();
		List<Long> sectorIdList = questionsWithPriority
				.stream()
				.map(q -> q.getAnswerStage1ByCompanyId(company.getId()))
				.map(a -> a.getValue())
				.map(s -> StaticUtils.parseLong(s))
				.collect(Collectors.toList());
		
		return secteurRepository.findAllByIdInOrderByIdAsc(sectorIdList);
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
		return questionStage1Repository.findAllByValidatorSideNumberIsNullOrValidatorSideNumberNotOrderByRankAsc(2);
	}

	@Override
	public List<QuestionStage2> findUserQuestionsStage2() {
		return questionStage2Repository.findAllByValidatorSideNumberNotOrderByRankAsc(2);
	}

	@Override
	public List<QuestionStage3> findUserQuestionsStage3() {
		return questionStage3Repository.findAllByValidatorSideNumberIsNullOrValidatorSideNumberNotOrderByRankAsc(2);
	}

	@Override
	public List<QuestionStage4> findUserQuestionsStage4() {
		return questionStage4Repository.findAllByValidatorSideNumberIsNullOrValidatorSideNumberNotOrderByRankAsc(2);
	}
	
	@Override
	public List<QuestionStage1> findCompanyQuestionsStage1() {
		return questionStage1Repository.findAllByValidatorSideNumberIsNullOrValidatorSideNumberNotOrderByRankAsc(1);
	}
	
	@Override
	public List<QuestionStage2> findAllQuestionsStage2ByCompany(Company company) {
		List<QuestionStage1> questionsWithPriority = questionStage1Repository.findAllByPrioritySectorNumberNotNullOrderByPrioritySectorNumberAsc();
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
		List<QuestionStage1> questionsWithPriority = questionStage1Repository.findAllByPrioritySectorNumberNotNullOrderByPrioritySectorNumberAsc();
		List<Long> sectorIdList = questionsWithPriority
				.stream()
				.map(q -> q.getAnswerStage1ByCompanyId(company.getId()))
				.map(a -> a.getValue())
				.map(s -> StaticUtils.parseLong(s))
				.collect(Collectors.toList());
		
		return questionStage2Repository.findAllByValidatorSideNumberIsNotAndSecteurIdIn(2, sectorIdList);
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
	public void saveAllAnswersAndFiles(Company company, Map<String, String> datas, List<Part> files) throws RuntimeException {
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
			
			if(nameList.length != 2 || value == null || value.isEmpty())
				continue;
			
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
				if(toSave1.size() == 0 && toSave2.size() == 0 && toSave3.size() == 0 && toSave4.size() == 0)
					return;
				
				throw new RuntimeException("invalid question");
		}
		
		this.saveCompanyFiles(company, files);
	}
	
	@Override
	public void saveCompanyFiles(Company company, List<Part> files) throws RuntimeException {
		if(files == null || files.size() == 0)
			return;
		
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
		for(Part file : files) {
			String inputName = file.getName();
			String contentType = file.getContentType();
			long size = file.getSize();
			String[] inputNameSplited = inputName.split("-");
			
			if(inputNameSplited.length != 2 || size <= 0L || contentType == null || contentType.isEmpty())
				continue;
			
			System.out.println("########### input name: " + inputName);
			
			Long questionId = StaticUtils.parseLong(inputNameSplited[1]);
			if(questionId == null || questionId <= 0L)
				throw new RuntimeException("incorrect questionId");
			
			String name = StaticUtils.saveFile(file, "attachment_" + inputNameSplited[0], company.getName());
			if(name == null || name.isEmpty())
				throw new RuntimeException("file not saved");
			
			switch (inputNameSplited[0]) {
				case "question1":
					questionStage = 1;
					QuestionStage1 q1 = this.findQuestionStage1ById(questionId);
					if(q1 == null)
						throw new RuntimeException("question not found");
					
					AnswerStage1 ans1 = q1.getAnswerStage1ByCompanyId(company.getId());
					if(ans1 == null) {
						ans1 = new AnswerStage1();
						ans1.setCompany(company);
						ans1.setQuestionstage1(q1);
					}
					
					ans1.setValue(name);
					ans1.setEditorUser(user);
					toSave1.add(ans1);
					break;
					
				case "question2":
					questionStage = 2;
					QuestionStage2 q2 = this.findQuestionStage2ById(questionId);
					if(q2 == null)
						throw new RuntimeException("question not found");
					
					AnswerStage2 ans2 = q2.getAnswerStage2ByCompanyId(company.getId());
					if(ans2 == null) {
						ans2 = new AnswerStage2();
						ans2.setCompany(company);
						ans2.setQuestionstage2(q2);
					}
					
					ans2.setValue(name);
					ans2.setEditorUser(user);
					toSave2.add(ans2);
					break;
					
				case "question3":
					questionStage = 3;
					QuestionStage3 q3 = this.findQuestionStage3ById(questionId);
					if(q3 == null)
						throw new RuntimeException("question not found");
					
					AnswerStage3 ans3 = q3.getAnswerStage3ByCompanyId(company.getId());
					if(ans3 == null) {
						ans3 = new AnswerStage3();
						ans3.setCompany(company);
						ans3.setQuestionstage3(q3);
					}
					
					ans3.setValue(name);
					ans3.setEditorUser(user);
					toSave3.add(ans3);
					break;
					
				case "question4":
					questionStage = 4;
					QuestionStage4 q4 = this.findQuestionStage4ById(questionId);
					if(q4 == null)
						throw new RuntimeException("question not found");
					
					AnswerStage4 ans4 = q4.getAnswerStage4ByCompanyId(company.getId());
					if(ans4 == null) {
						ans4 = new AnswerStage4();
						ans4.setCompany(company);
						ans4.setQuestionstage4(q4);
					}
					
					ans4.setValue(name);
					ans4.setEditorUser(user);
					toSave4.add(ans4);
					break;
	
				default:
					throw new RuntimeException("invalid question file");
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
				if(toSave1.size() == 0 && toSave2.size() == 0 && toSave3.size() == 0 && toSave4.size() == 0)
					return;
				
				throw new RuntimeException("invalid question file");
		}
	}

	@Override
	public boolean isStage1CompletedByCompany(Company company) {
		// For instance only check if the three priority are set.
		List<QuestionStage1> questionsWithPriority = questionStage1Repository.findAllByPrioritySectorNumberNotNullOrderByPrioritySectorNumberAsc();
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

	@Override
	public ProgressDto getProgress(Company company) {
		ProgressDto progress = new ProgressDto();
		
		// get the total number of questions
		Long totalValidationQuestionNumberStage1 = questionStage1Repository.countByTypeAndValidatorSideNumberNotNull("boolean");
		Long totalValidationQuestionNumberStage3 = questionStage3Repository.countByTypeAndValidatorSideNumberNotNull("boolean");
		Long totalValidationQuestionNumberStage4 = questionStage4Repository.countByTypeAndValidatorSideNumberNotNull("boolean");
		
		List<QuestionStage1> questionsWithPriority = questionStage1Repository.findAllByPrioritySectorNumberNotNullOrderByPrioritySectorNumberAsc();
		List<Long> sectorIdList = questionsWithPriority
				.stream()
				.map(q -> q.getAnswerStage1ByCompanyId(company.getId()))
				.map(a -> a.getValue())
				.map(s -> StaticUtils.parseLong(s))
				.collect(Collectors.toList());
		
		List<String> sectorNames = sectorIdList
				.stream()
				.map(id -> this.findSecteurById(id))
				.map(aSec -> aSec != null ? aSec.getName() : "")
				.collect(Collectors.toList());
		
		List<Long> stage2SectorCounts = new ArrayList<>();
		for(Long sectorId : sectorIdList) {
			Long aCount = questionStage2Repository.countByTypeAndValidatorSideNumberNotNullAndSecteur_id("boolean", sectorId);
			stage2SectorCounts.add(aCount);
		}
		
		//get the company's responses at validation questions
		List<AnswerStage1> ans1 = answerStage1Repository.findAllByCompanyAndQuestionstage1_ValidatorSideNumberNotNull(company);
		List<AnswerStage3> ans3 = answerStage3Repository.findAllByCompanyAndQuestionstage3_ValidatorSideNumberNotNull(company);
		List<AnswerStage4> ans4 = answerStage4Repository.findAllByCompanyAndQuestionstage4_ValidatorSideNumberNotNull(company);
		List<List<AnswerStage2>> ans2 = new ArrayList<>();
		for(Long sectorId : sectorIdList) {
			List<AnswerStage2> an2 = answerStage2Repository.findAllByCompanyAndQuestionstage2_ValidatorSideNumberNotNullAndQuestionstage2_Secteur_Id(company, sectorId);
			ans2.add(an2);
		}
		
		//compute progress values
		progress.setStage1Validator(StaticUtils.getUsernameOfResponderFromAnswer1(ans1));
		if(ans1 != null) {
			int sta = (int) (100 * StaticUtils.getNumberOfYesAnswers1(ans1) / totalValidationQuestionNumberStage1);
			progress.setStage1(sta);
		}
		
		progress.setStage3Validator(StaticUtils.getUsernameOfResponderFromAnswer3(ans3));
		if(ans3 != null) {
			int sta = (int) (100 * StaticUtils.getNumberOfYesAnswers3(ans3) / totalValidationQuestionNumberStage3);
			progress.setStage3(sta);
		}
		
		progress.setStage4Validator(StaticUtils.getUsernameOfResponderFromAnswer4(ans4));
		if(ans4 != null) {
			int sta = (int) (100 * StaticUtils.getNumberOfYesAnswers4(ans4) / totalValidationQuestionNumberStage4);
			progress.setStage4(sta);
		}
		
		for(int i=0; i<ans2.size(); i++) {
			List<AnswerStage2> a2 = ans2.get(i);
			
			if(i == 0) {
				//first priority sector
				int res = (int) (100 * StaticUtils.getNumberOfYesAnswers2(a2) / stage2SectorCounts.get(i));
				progress.setStage2FirstPriority(res);
				progress.setStage2FirstPriorityValidator(StaticUtils.getUsernameOfResponderFromAnswer2(a2));
				progress.setFirstPriorityName(sectorNames.get(i));
				
				continue;
			}
			
			if(i == 1) {
				//second priority sector
				int res = (int) (100 * StaticUtils.getNumberOfYesAnswers2(a2) / stage2SectorCounts.get(i));
				progress.setStage2SecondPriority(res);
				progress.setStage2SecondPriorityValidator(StaticUtils.getUsernameOfResponderFromAnswer2(a2));
				progress.setSecondPriorityName(sectorNames.get(i));
				
				continue;
			}
			
			if(i == 2) {
				//third priority sector
				int res = (int) (100 * StaticUtils.getNumberOfYesAnswers2(a2) / stage2SectorCounts.get(i));
				progress.setStage2ThirdPriority(res);
				progress.setStage2ThirdPriorityValidator(StaticUtils.getUsernameOfResponderFromAnswer2(a2));
				progress.setThirdPriorityName(sectorNames.get(i));
			}
		}
		
		int glo2 = (progress.getStage2FirstPriority() + progress.getStage2SecondPriority() + progress.getStage2ThirdPriority()) / 3;
		progress.setStage2Global(glo2);
		
		int glo = (progress.getStage1() + glo2 + progress.getStage3() + progress.getStage4()) / 4;
		progress.setGlobal(glo);
		
		return progress;
	}

	@Override
	public AnswerStage1 saveAnswerStage1(AnswerStage1 answerStage1) {
		return answerStage1Repository.save(answerStage1);
	}

	@Override
	public AnswerStage2 saveAnswerStage2(AnswerStage2 answerStage2) {
		return answerStage2Repository.save(answerStage2);
	}
}
