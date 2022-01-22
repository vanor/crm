package com.crm.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.crm.app.entity.Permission;
import com.crm.app.repository.PermissionRepository;

@Controller 
public class PermissionController {
	
	@Autowired
	PermissionRepository permissionRepository;
	
	@RequestMapping(value = "/permissions", method = RequestMethod.GET)
	public ModelAndView showPermissions(Model model) {

		List<Permission> lspermission = permissionRepository.findAll();
		
		System.out.print(lspermission.toString());
		
		model.addAttribute("liste", permissionRepository.findAll());
		
	    return new ModelAndView("permission/permission" );
	}

}
