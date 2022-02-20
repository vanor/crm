package com.crm.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crm.app.entity.Reporting;
import com.crm.app.entity.Utilisateur;
import com.crm.app.model.PojoReport;
import com.crm.app.repository.ReportingRepository;
import com.crm.app.repository.UtilisateurRepository;


@Controller
public class ReportingController {
	
	@Autowired
	ReportingRepository reportRepository;
	
	@Autowired
	UtilisateurRepository userRepository;
	
	@RequestMapping(value = "/create-new-report", method = RequestMethod.GET)
	public ModelAndView newreport(Model model) {

		
		model.addAttribute("report", new Reporting());
		
	    return new ModelAndView("report/create" );
	}
	
	@RequestMapping(value = "/saveReport", method = RequestMethod.POST)
	public ModelAndView saveReport(Model model,@ModelAttribute Reporting report,final RedirectAttributes redirectAttributes) {
		
		report.setCreatedAt(new Date());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = auth.getName(); 
		
		Utilisateur AuthUser = userRepository.findByLogin(login);
		
		report.setUser(AuthUser);

		Reporting reportSave = reportRepository.save(report);
		model.addAttribute("report", new Reporting()); 
		if(reportSave!=null) {
			model.addAttribute("infos","Operation Successfully Completed");
		    return new ModelAndView("report/create" );
		}  
		
		model.addAttribute("error", "The operation failed");
	    return new ModelAndView("report/create" );
	}
	
	@RequestMapping(value = "/search-report", method = RequestMethod.GET)
	public ModelAndView listreport(Model model) {


		model.addAttribute("search",new PojoReport());
		model.addAttribute("liste", null);
		
	    return new ModelAndView("report/listreports" );
	}  

}
