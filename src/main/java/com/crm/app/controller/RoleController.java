package com.crm.app.controller;

import java.security.Permissions;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crm.app.entity.Permission;
import com.crm.app.entity.Role;
import com.crm.app.model.RolePermission;
import com.crm.app.repository.PermissionRepository;
import com.crm.app.repository.RoleRepository;


@Controller 
public class RoleController {
	
	@Autowired
	RoleRepository roleRepository;
		
	@Autowired
	PermissionRepository permissionRepository;
	
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public ModelAndView showRoles(Model model) {

		List<Role> lsrole = roleRepository.findAll();
		
		
		//System.out.print(lspermission.toString());
		
		model.addAttribute("liste", roleRepository.findAll());
		
	    return new ModelAndView("role/roles" );
	}
	
	
	@RequestMapping(value = "/saverole", method = RequestMethod.POST)
	public ModelAndView newRole(Model model,@ModelAttribute Role role,final RedirectAttributes redirectAttributes) {
		
		Role rolewithsamename = roleRepository.findByName(role.getName().trim());
		
		if(rolewithsamename!=null) {
			model.addAttribute("error", "Role name already used");  
			return new ModelAndView("role/create" ); 
		}
		
		role.setCreatedAt(new Date());
		role.setName(role.getName().trim());
		role = roleRepository.save(role);
		
		redirectAttributes.addAttribute("roleid",role.getId());
		redirectAttributes.addFlashAttribute("infos","Operation Successfully Completed");
	    return new ModelAndView("redirect:/details" );
	}
	
	@RequestMapping(value = "/Addrole", method = RequestMethod.GET)
	public ModelAndView newRoleget(Model model) {

		model.addAttribute("role", new Role());
		
	    return new ModelAndView("role/create" );
	}
	
	@RequestMapping(value = "/showUpdateForm", method = RequestMethod.GET)
	public ModelAndView showUpdateForm(Model model,@RequestParam Long roleid) {

		ModelAndView mav = new ModelAndView("/role/create");
		
		Role role = roleRepository.findById(roleid).get();
		model.addAttribute("role", role);
		
	    return new ModelAndView("role/create" );
	}

	@RequestMapping(value = "/deleteForm", method = RequestMethod.GET)
	public ModelAndView deleteForm(Model model,@RequestParam Long roleid,final RedirectAttributes redirectAttributes) {
 
		roleRepository.deleteById(roleid);
		redirectAttributes.addFlashAttribute("infos","Operation Successfully Completed");
	    return new ModelAndView("redirect:/roles" );
	}

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String getRoleById(Model model,@RequestParam Long roleid,final RedirectAttributes redirectAttributes) {

    	
        Role role = roleRepository.findById(roleid).get();

        model.addAttribute("role",role);

        List<Permission> permissions = permissionRepository.findAll();
        
        RolePermission rolep = new RolePermission();
        rolep.setRoleId(roleid);
        
		model.addAttribute("rolep", rolep);
		
        if(role.getPermissions() != null && role.getPermissions().size() > 0)
            permissions.removeAll(role.getPermissions());

        model.addAttribute("permissions", permissions);
        return "role/details";
    }
    
    @RequestMapping(value = "/addsubpermissions", method = RequestMethod.POST)
    public String addsubpermissions(@ModelAttribute RolePermission rolep,Model model, final RedirectAttributes redirectAttributes) {

		Role currentrole = new Role();
		Permission perm = new Permission(); 
    	for(Long idp:rolep.getPermissionIds()) {
    		currentrole = roleRepository.findById(rolep.getRoleId()).get();
    		perm = permissionRepository.findById(idp).get();
    		Set<Permission> permissions = currentrole.getPermissions();
    		permissions.add(perm);
    		currentrole.setPermissions(permissions);
    		currentrole = roleRepository.save(currentrole);
    	}
		redirectAttributes.addFlashAttribute("infos","Operation Successfully Completed");
    	redirectAttributes.addAttribute("roleid",rolep.getRoleId());

        return "redirect:/details";
    }
    
    @RequestMapping(value = "/delsubpermissions", method = RequestMethod.GET)
    public String delsubpermissions(@RequestParam Long permissionid,Model model,@RequestParam Long roleid, final RedirectAttributes redirectAttributes) {

		Role currentrole = new Role();
		Permission perm = new Permission();

    		currentrole = roleRepository.findById(roleid).get();
    		perm = permissionRepository.findById(permissionid).get();
    		Set<Permission> permissions = currentrole.getPermissions();
    		permissions.remove(perm);
    		currentrole.setPermissions(permissions);
    		currentrole = roleRepository.save(currentrole);
  
    		redirectAttributes.addFlashAttribute("infos","Operation Successfully Completed");
    		redirectAttributes.addAttribute("roleid",roleid);

        return "redirect:/details";
    }
}
