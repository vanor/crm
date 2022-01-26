package com.crm.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.crm.app.entity.Utilisateur;
import com.crm.app.repository.UtilisateurRepository;
import com.crm.app.service.UserService;

@Service
public class UserServiceImplx implements UserService{
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	UtilisateurRepository userRepository;
	
	@Override
	public Utilisateur createUser(Utilisateur user) {
		// TODO Auto-generated method stub
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		userRepository.saveAndFlush(user);
		
		return user;
	}

}
