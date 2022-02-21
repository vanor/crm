package com.crm.app.controller;

import java.util.ArrayList;
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
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = auth.getName(); 
		
		Utilisateur AuthUser = userRepository.findByLogin(login);
		
		List<Utilisateur> users = new ArrayList<>();
		users.add(AuthUser); 
		List<Utilisateur> Usrs = userRepository.findAllBySupervisor(AuthUser);
		for(Utilisateur u:Usrs) {
			if(u!=AuthUser)
				users.add(u);
		}

		model.addAttribute("users",users);
		model.addAttribute("search",new PojoReport());
		model.addAttribute("liste", reportRepository.findAllByUser(AuthUser));
		
	    return new ModelAndView("report/listreports" );
	}  
	
	@RequestMapping(value = "/search-report", method = RequestMethod.POST)
	public ModelAndView listreport2(Model model,@ModelAttribute PojoReport search) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = auth.getName(); 
		
		Utilisateur AuthUser = userRepository.findByLogin(login);
		List<Reporting> reports = null;
		List<Utilisateur> users = new ArrayList<>();
		users.add(AuthUser); 
		List<Utilisateur> Usrs = userRepository.findAllBySupervisor(AuthUser);
		for(Utilisateur u:Usrs) {
			if(u!=AuthUser)
				users.add(u);
		}
				
		
		if(search.getId()!=null)
			reports= reportRepository.findAllBydate(search.getId()+"",search.getFin(),search.getDebut());
		else
			reports= reportRepository.findAllBydate(AuthUser.getId()+"",search.getFin(),search.getDebut());

		model.addAttribute("search",new PojoReport());
		model.addAttribute("users",users);
		model.addAttribute("liste", reports);
		
	    return new ModelAndView("report/listreports" );
	} 

}
