package com.crm.app.component;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crm.app.entity.Permission;
import com.crm.app.entity.Role;
import com.crm.app.entity.Utilisateur;
import com.crm.app.service.UserService;

@Service
public class UserDetailService implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur utilisateur = userService.findByLogin(username);
		if(utilisateur == null)
			throw new UsernameNotFoundException("User " + username + " not found");
		
		//get the list of permissions and add it to the final object to return
		Set<GrantedAuthority> authorities = new HashSet<>();
		for(Role role : utilisateur.getRoles()) {
			if(role.getGuardName() != null && role.getGuardName().equals("super_admin")) {
				authorities.add(new SimpleGrantedAuthority("super_admin"));
				continue;
			}
			
			for(Permission permission : role.getPermissions())
				authorities.add(new SimpleGrantedAuthority(permission.getGuardName()));
		}
		
		return new User(utilisateur.getLogin(), utilisateur.getPassword(), authorities);
	}
}
