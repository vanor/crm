package com.crm.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crm.app.dto.AccountDto;
import com.crm.app.entity.Account;
import com.crm.app.entity.Business;
import com.crm.app.entity.Utilisateur;
import com.crm.app.repository.AccountRepository;
import com.crm.app.repository.BusinessRepository;
import com.crm.app.utils.StaticUtils;


@Controller 
public class RegisterController {
	
	@Autowired
	BusinessRepository businessRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	/*@RequestMapping(value = "/redirect", method = RequestMethod.POST)
	public ModelAndView method() {

	    return new ModelAndView("result" );
	}*/
	
	@RequestMapping(value = "/resultat", method = RequestMethod.POST)
	public ModelAndView result() {
	    return new ModelAndView("result" );
	}
	
	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public ModelAndView methodget() {
	    return new ModelAndView("redirect:/enquiry" );
	}
	
	@RequestMapping(value = "/register-your-business", method = RequestMethod.GET)
	public ModelAndView getform(Model model) {
		
		model.addAttribute("business",new Business());
	    return new ModelAndView("register" );
	}
	
	@RequestMapping(value = "/register-your-account", method = RequestMethod.GET)
	public ModelAndView getformaccount(Model model) {
		
		model.addAttribute("account",new AccountDto());
	    return new ModelAndView("register_provider" );
	}
	
	@RequestMapping(value = "/registration-business", method = RequestMethod.GET)
	public ModelAndView getBusiness(Model model) {
		
		model.addAttribute("liste",businessRepository.findAll());
	    return new ModelAndView("registration/business/index" );
	}

	@RequestMapping(value = "/saveBusiness", method = RequestMethod.POST)
	public ModelAndView newBusiness(Model model,@ModelAttribute Business business, final RedirectAttributes redirectAttributes) {
		
		business.setCreatedAt(new Date());
		business.setStatus("");
		businessRepository.save(business);
		
		 return new ModelAndView("result" );	
	}
	
	@RequestMapping(value = "/new-account", method = RequestMethod.POST)
	public String addNewCompany(@ModelAttribute AccountDto accountDto, RedirectAttributes ra) {
		String validationString = accountDto.checkRequired();
	/*	if(!validationString.equals("ok")) {
			ra.addFlashAttribute("error", validationString);
			return "redirect:/register-your-account";
		}*/
		
		
		Account account = new Account();
		account.setName(accountDto.getName());
		account.setAboutUs(accountDto.getAboutUs());
		account.setLine1(accountDto.getLine1());
		account.setLine2(accountDto.getLine2());
		account.setLine3(accountDto.getLine3());
		account.setCity(accountDto.getCity());
		account.setPostalCode(accountDto.getPostalCode());
		account.setLocalAuthority(accountDto.getLocalAuthority());
		account.setContactName(accountDto.getContactName());
		account.setContactEmail(accountDto.getContactEmail());
		account.setContactPhoneNumber(accountDto.getContactPhoneNumber());
		account.setWebsite(accountDto.getWebsite());
		
		// process logo to save and get the link
		String logoName = StaticUtils.saveFile(accountDto.getLogo(), "logo", accountDto.getName());
		if(logoName == null || logoName.isEmpty()) {
			ra.addFlashAttribute("error", "logo not saved");
			return "redirect:/register-your-account";
		}
		
		account.setLogoLink(logoName);
		Account savedCompany = accountRepository.save(account);
		if(savedCompany == null) {
			ra.addFlashAttribute("error", "Account not saved");
			return "redirect:/register-your-account";
		}
		
		ra.addFlashAttribute("success", "Account saved");
		
		return "result";
	}
	
	@RequestMapping(value = "/registration-account", method = RequestMethod.GET)
	public String getCompanies(Model model) {
		List<Account> accounts = accountRepository.findAll();
		model.addAttribute("accounts", accounts);
		 
		return "registration/account/index";
	}
}
