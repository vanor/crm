package com.crm.app.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crm.app.dto.CompanyDto;
import com.crm.app.entity.Company;
import com.crm.app.entity.Permission;
import com.crm.app.entity.Role;
import com.crm.app.entity.Utilisateur;
import com.crm.app.model.CompanyUsers;
import com.crm.app.model.UserRoles;
import com.crm.app.repository.UtilisateurRepository;
import com.crm.app.service.CompanyService;
import com.crm.app.utils.StaticUtils;

@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	UtilisateurRepository userRepository;

	@RequestMapping(value = "/companies", method = RequestMethod.GET)
	public String getCompanies(Model model) {
		List<Company> companies = companyService.findAll();
		model.addAttribute("companies", companies);
		
		return "company/index";
	}
	
	@RequestMapping(value = "/new-company", method = RequestMethod.GET)
	public String getNewCompany(Model model) {
		model.addAttribute("company", new CompanyDto());
		
		return "company/create";
	}
	
	@RequestMapping(value = "/new-company", method = RequestMethod.POST)
	public String addNewCompany(@ModelAttribute CompanyDto companyDto, RedirectAttributes ra) {
		/*String validationString = companyDto.checkRequired(true);
		if(!validationString.equals("ok")) {
			ra.addFlashAttribute("error", validationString);
			return "redirect:/new-company";
		}*/
		 
		Company existingCompany = companyService.findByName(companyDto.getName());
		if(existingCompany != null) {
			ra.addFlashAttribute("error", "company already existing");
			return "redirect:/new-company";
		}
		
		Company company = new Company();
		company.setName(companyDto.getName());
		company.setEmail(companyDto.getEmail());
		company.setPhoneNumber(companyDto.getPhoneNumber());
		company.setMessage(companyDto.getMessage());
		company.setAboutUs(companyDto.getAboutUs());
		company.setLine1(companyDto.getLine1());
		company.setLine2(companyDto.getLine2());
		company.setLine3(companyDto.getLine3());
		company.setCity(companyDto.getCity());
		company.setPostalCode(companyDto.getPostalCode());
		company.setLocalAuthority(companyDto.getLocalAuthority());
		company.setContactName(companyDto.getContactName());
		company.setContactEmail(companyDto.getContactEmail());
		company.setContactPhoneNumber(companyDto.getContactPhoneNumber());
		company.setWebsite(companyDto.getWebsite());
		
		// process logo to save and get the link
		String logoName = StaticUtils.saveFile(companyDto.getLogo(), "logo", companyDto.getName());
		if(logoName == null || logoName.isEmpty()) {
			/*ra.addFlashAttribute("error", "logo not saved");
			return "redirect:/new-company";*/
			
			logoName = StaticUtils.LOGO_BASE_LOCATION;
		}
		
		company.setLogoLink(logoName);
		Company savedCompany = companyService.save(company);
		if(savedCompany == null) {
			ra.addFlashAttribute("error", "company not saved");
			return "redirect:/new-company";
		}
		
		ra.addFlashAttribute("success", "company saved");
		
		return "redirect:/companies";
	}
	
	@RequestMapping(value = "/view-company-{id}", method = RequestMethod.GET)
	public String getCompany(@PathVariable Long id, Model model, RedirectAttributes ra) {
		Company company = companyService.findById(id);
		if(company == null) {
			ra.addFlashAttribute("error", "company not found");
			return "redirect:/companies";
		}
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = auth.getName(); 
		
		Utilisateur AuthUser = userRepository.findByLogin(login);
		if(isOperationalManagers(AuthUser)||company.getUsers().contains(AuthUser)||company.getUsers()==null||company.getUsers().size()==0) {
			
		}else {
			ra.addFlashAttribute("error", "You do not have access to this company");
			return "redirect:/companies";

		}
		
		model.addAttribute("company", company);
		model.addAttribute("sectors", companyService.findAllSectors());
		model.addAttribute("questionStage1", companyService.findAllQuestionsStage1());
		
		boolean isStage1Completed = companyService.isStage1CompletedByCompany(company);
		if(isStage1Completed) {
			model.addAttribute("questionStage2", companyService.findAllQuestionsStage2ByCompany(company));
			model.addAttribute("questionStage3", companyService.findAllQuestionsStage3());
			model.addAttribute("questionStage4", companyService.findAllQuestionsStage4());
		}
		
		
		return "company/detail";
	}
	
	@RequestMapping(value = "/edit-company-{id}", method = RequestMethod.GET)
	public String getCompanyToEdit(@PathVariable Long id, Model model, RedirectAttributes ra) {
		Company company = companyService.findById(id);
		if(company == null) {
			ra.addFlashAttribute("error", "company not found");
			return "redirect:/companies";
		}
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = auth.getName(); 
		
		Utilisateur AuthUser = userRepository.findByLogin(login);
		if(isOperationalManagers(AuthUser)||company.getUsers().contains(AuthUser)) {
			
		}else {
			ra.addFlashAttribute("error", "You do not have access to this company");

			return "redirect:/companies";

		}
		
		
		model.addAttribute("company", CompanyDto.fromCompany(company));
		model.addAttribute("sectors", companyService.findAllSectors());
		model.addAttribute("questionStage1", companyService.findAllQuestionsStage1());
		
		boolean isStage1Completed = companyService.isStage1CompletedByCompany(company);
		if(isStage1Completed) {
			model.addAttribute("questionStage2", companyService.findAllQuestionsStage2ByCompany(company));
			model.addAttribute("questionStage3", companyService.findAllQuestionsStage3());
			model.addAttribute("questionStage4", companyService.findAllQuestionsStage4());
		}
		
		return "company/edit";
	}
	
	@RequestMapping(value = "/edit-company", method = RequestMethod.POST)
	public String editCompany(@ModelAttribute CompanyDto companyDto, RedirectAttributes ra) {
		/*String validationString = companyDto.checkRequired(false);
		if(!validationString.equals("ok")) {
			ra.addFlashAttribute("error", validationString);
			return "redirect:/new-company";
		}*/
		
		Company company = companyService.findById(companyDto.getId());
		if(company == null) {
			ra.addFlashAttribute("error", "company not found");
			return "redirect:/new-company";
		}
		
		Company existingCompany = companyService.findByName(companyDto.getName());
		if(existingCompany != null && existingCompany.getId() != company.getId()) {
			ra.addFlashAttribute("error", "company name already existing");
			return "redirect:/new-company";
		}
		
		company.setName(companyDto.getName());
		company.setEmail(companyDto.getEmail());
		company.setPhoneNumber(companyDto.getPhoneNumber());
		company.setMessage(companyDto.getMessage());
		company.setAboutUs(companyDto.getAboutUs());
		company.setLine1(companyDto.getLine1());
		company.setLine2(companyDto.getLine2());
		company.setLine3(companyDto.getLine3());
		company.setCity(companyDto.getCity());
		company.setPostalCode(companyDto.getPostalCode());
		company.setLocalAuthority(companyDto.getLocalAuthority());
		company.setContactName(companyDto.getContactName());
		company.setContactEmail(companyDto.getContactEmail());
		company.setContactPhoneNumber(companyDto.getContactPhoneNumber());
		company.setWebsite(companyDto.getWebsite());
		
		if(companyDto.getLogo() != null && !companyDto.getLogo().isEmpty()) {
			String logoName = StaticUtils.saveFile(companyDto.getLogo(), "logo", companyDto.getName());
			if(logoName == null || logoName.isEmpty()) {
				ra.addFlashAttribute("error", "logo not saved");
				return "redirect:/new-company";
			}
			
			company.setLogoLink(logoName);
		}
		
		Company savedCompany = companyService.save(company);
		if(savedCompany == null) {
			ra.addFlashAttribute("error", "company not updated");
			return "redirect:/new-company";
		}
		
		ra.addFlashAttribute("success", "company updated");
		
		return "redirect:/view-company-" + savedCompany.getId();
	}
	
	@RequestMapping(value = "/edit-stage", method = RequestMethod.POST)
	public String editStage1(HttpServletRequest request, RedirectAttributes ra) {
		Map<String, String> params = StaticUtils.getParams(request);
		System.out.println("######### params: " + params);
		
		Long companyId = StaticUtils.parseLong(params.get("companyId"));
		if(companyId == null || companyId <= 0L) {
			ra.addFlashAttribute("error", "companyId was incorrect");
			return "redirect:/companies";
		}
		
		Company company = companyService.findById(companyId);
		if(company == null) {
			ra.addFlashAttribute("error", "company not found");
			return "redirect:/companies";
		}
		
		try {
			companyService.saveAllAnswers(company, params);
			ra.addFlashAttribute("success", "stage 1 updated");
			
			return "redirect:/view-company-" + companyId;
			
		} catch (RuntimeException re) {
			re.printStackTrace();
			ra.addFlashAttribute("error", re.getMessage());
		}
		
		return "redirect:/view-company-" + companyId;
	}
	
	@RequestMapping(value = "/files/{filename:.+}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		Resource file = StaticUtils.getFileByName(filename);
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
	
	 @RequestMapping(value = "/CompanyUser", method = RequestMethod.GET)
	    public String companyuser(Model model,@RequestParam Long companyid, final RedirectAttributes redirectAttributes) {
		 
		 Company company = companyService.findById(companyid);
		 model.addAttribute("company",company);
		 List<Utilisateur> users = userRepository.findAll();
		 
		 CompanyUsers companyuser = new CompanyUsers();
		 companyuser.setCompanyId(company.getId());
		 model.addAttribute("companyu",companyuser);
		 
		 if(company.getUsers()!= null && company.getUsers().size() > 0)
	            users.removeAll(company.getUsers());

	        model.addAttribute("users", users);
	        
	        return "company/users";
	 }
	 
	 @RequestMapping(value = "/addUserInCompny", method = RequestMethod.POST)
	    public String adduser(@ModelAttribute CompanyUsers companyu,Model model, final RedirectAttributes redirectAttributes) {
		 
		 Company company = new Company();
		 
		 Utilisateur user = new Utilisateur();
		 
		 for(Long idu:companyu.getUserIds()) {
			company = companyService.findById(companyu.getCompanyId());
			user = userRepository.findById(idu).get();
			Set<Utilisateur> users = company.getUsers();
			users.add(user);
			company.setUsers(users);
			Company savedCompany = companyService.save(company);
			 
		 }
		 redirectAttributes.addFlashAttribute("infos","Operation Successfully Completed");
	    	redirectAttributes.addAttribute("companyid",companyu.getCompanyId());
	    	
	    	return "redirect:/CompanyUser";
		 
	 }
	 
	 @RequestMapping(value = "/delUserCompany", method = RequestMethod.GET)
	    public String deluser(@RequestParam Long userid,Model model,@RequestParam Long companyid, final RedirectAttributes redirectAttributes) {
		 
		 Company company = new Company();		 
		 Utilisateur user = new Utilisateur();
		 
		 	company = companyService.findById(companyid);
			user = userRepository.findById(userid).get();
			Set<Utilisateur> users = company.getUsers();
			users.remove(user);
			company.setUsers(users);
			Company savedCompany = companyService.save(company);
			
			redirectAttributes.addFlashAttribute("infos","Operation Successfully Completed");
	    	redirectAttributes.addAttribute("companyid",companyid);
	    	
	    	return "redirect:/CompanyUser";
	 }

	private boolean isOperationalManagers(Utilisateur user) {
		
		Set<Role> roles = user.getRoles();
		
		for(Role role:roles) {
			Set<Permission> permissions = role.getPermissions();
			for(Permission perm:permissions) {
				if(perm.getName().equalsIgnoreCase("edt_stage_4"))
					return true;
			}
		}
		
		return false;
	}
}
