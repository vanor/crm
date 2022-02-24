package com.crm.app.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crm.app.entity.Permission;
import com.crm.app.entity.Role;
import com.crm.app.entity.Utilisateur;
import com.crm.app.model.RolePermission;
import com.crm.app.model.UserRoles;
import com.crm.app.repository.RoleRepository;
import com.crm.app.repository.UtilisateurRepository;
import com.crm.app.service.UserService;


@Controller 
public class UserController {

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UtilisateurRepository userRepository;
	
	@Autowired
	UserService userService;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView listusers(Model model) {

		List<Utilisateur> lsuser = userRepository.findAll();

		
		//System.out.print(lspermission.toString());
		
		model.addAttribute("liste", userRepository.findAll());
		
	    return new ModelAndView("user/index" );
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView newRole(Model model,@ModelAttribute Utilisateur user, final RedirectAttributes redirectAttributes) {
		
		Utilisateur userwithlogin = userRepository.findByLogin(user.getLogin());
		if(userwithlogin!=null) {
			if(user.getId()!=null) {
				if(user.getId()==userwithlogin.getId()) {
					
				}else {
					model.addAttribute("error", "Login already used");  
					model.addAttribute("user", user);  
					  return new ModelAndView("user/create" );
				}
			}else {
				model.addAttribute("error", "Login already used");  
				model.addAttribute("user", user);  
				  return new ModelAndView("user/create" );
			}
			
		}
		
		if(user.getId()==null) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		}else {
			if(user.getPassword()==null||user.getPassword().equalsIgnoreCase("")) {
				Utilisateur thisUser = userRepository.findById(user.getId()).get();
				if(thisUser!=null) {
					user.setPassword(thisUser.getPassword());
					user.setRoles(thisUser.getRoles());
					user.setCreatedAt(thisUser.getCreatedAt());
					user.setSupervisor(thisUser.getSupervisor()!=null?thisUser.getSupervisor():null);
					user.setUpdatedAt(new Date());
				}
			}else {
				user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			}
		}
		
		if(user.getId()==null)
		user.setCreatedAt(new Date());
		user.setLogin(user.getLogin().trim());
		user.setUsername(user.getLogin().trim()); 
		user = userService.createUser(user);
		redirectAttributes.addFlashAttribute("infos","Operation Successfully Completed");
		redirectAttributes.addAttribute("userid",user.getId());
		
	    return new ModelAndView("redirect:/detailsUser" );
	     
	}
	
	@RequestMapping(value = "/AddUser", method = RequestMethod.GET)
	public ModelAndView newRoleget(Model model) {

		model.addAttribute("user", new Utilisateur());
		model.addAttribute("users", userRepository.findAll());  

	    return new ModelAndView("user/create" );
	}
	
	@RequestMapping(value = "/showUpdateuser", method = RequestMethod.GET)
	public ModelAndView showUpdateForm(Model model,@RequestParam Long userid) {
		
		Utilisateur user = userRepository.findById(userid).get();
		model.addAttribute("user", user);  
		model.addAttribute("users", userRepository.findAll());  
		
	    return new ModelAndView("user/create" );
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public ModelAndView deleteForm(Model model,@RequestParam Long userid, final RedirectAttributes redirectAttributes) {

		userRepository.deleteById(userid);
		redirectAttributes.addFlashAttribute("infos","Operation Successfully Completed");
	    return new ModelAndView("redirect:/users" );
	}
	
	 @RequestMapping(value = "/detailsUser", method = RequestMethod.GET)
	    public String getRoleById(Model model,@RequestParam Long userid, final RedirectAttributes redirectAttributes) {

	    	
	        Utilisateur user = userRepository.findById(userid).get();

	        model.addAttribute("user",user);

	        List<Role> roles = roleRepository.findAll();
	        
	        UserRoles userr = new UserRoles();
	        userr.setUserId(userid);
	        
			model.addAttribute("userr", userr);
			
	        if(user.getRoles() != null && user.getRoles().size() > 0)
	            roles.removeAll(user.getRoles());

	        model.addAttribute("roles", roles);
	        model.addAttribute("users", userRepository.findAll());
	        
	        return "user/details";
	    }
	    
	    @RequestMapping(value = "/addsubrole", method = RequestMethod.POST)
	    public String addsubpermissions(@ModelAttribute UserRoles userr,Model model, final RedirectAttributes redirectAttributes) {

			Utilisateur currentuser = new Utilisateur();
			Role role = new Role();
	    	for(Long idr:userr.getRoleIds()) {
	    		currentuser = userRepository.findById(userr.getUserId()).get();
	    		role = roleRepository.findById(idr).get();
	    		Set<Role> roles = currentuser.getRoles();
	    		roles.add(role);
	    		currentuser.setRoles(roles);
	    		currentuser.setRole(role.getName());
	    		currentuser = userRepository.save(currentuser);
	    	}
			redirectAttributes.addFlashAttribute("infos","Operation Successfully Completed");
	    	redirectAttributes.addAttribute("userid",userr.getUserId());

	        return "redirect:/detailsUser";
	    }
	    
	    @RequestMapping(value = "/set-supervisor", method = RequestMethod.POST)
	    public String addsupervisor(@ModelAttribute UserRoles userr,Model model, final RedirectAttributes redirectAttributes) {

			Utilisateur currentuser = new Utilisateur();
    		Utilisateur supervisor = new Utilisateur();

			
	    	for(Long idr:userr.getRoleIds()) {
	    		currentuser = userRepository.findById(userr.getUserId()).get();
	    		supervisor = userRepository.findById(idr).get();
	    		currentuser.setSupervisor(supervisor);
	    		currentuser = userRepository.save(currentuser);
	    	}
			redirectAttributes.addFlashAttribute("infos","Operation Successfully Completed");
	    	redirectAttributes.addAttribute("userid",userr.getUserId());

	        return "redirect:/detailsUser";
	    }

	    @RequestMapping(value = "/delsubrole", method = RequestMethod.GET)
	    public String delsubrole(@RequestParam Long roleid,Model model,@RequestParam Long userid, final RedirectAttributes redirectAttributes) {

			Utilisateur currentuser = new Utilisateur();
			Role role = new Role();
 
	    		currentuser = userRepository.findById(userid).get();
	    		role = roleRepository.findById(roleid).get();
	    		Set<Role> roles = currentuser.getRoles();
	    		roles.remove(role);
	    		currentuser.setRoles(roles);
	    		currentuser.setRole("");
	    		currentuser = userRepository.save(currentuser);
	  
	    		redirectAttributes.addFlashAttribute("infos","Operation Successfully Completed");
	    	
	    	redirectAttributes.addAttribute("userid",userid);
	    	

	        return "redirect:/detailsUser";
	    }
	
}
