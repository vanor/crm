package com.crm.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.crm.app.entity.Permission;
import com.crm.app.entity.Role;
import com.crm.app.repository.RoleRepository;


@Controller 
public class RoleController {
	
	@Autowired
	RoleRepository roleRepository;
	
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public ModelAndView showRoles(Model model) {

		List<Role> lsrole = roleRepository.findAll();
		
		
		//System.out.print(lspermission.toString());
		
		model.addAttribute("liste", roleRepository.findAll());
		
	    return new ModelAndView("role/roles" );
	}

}
