package com.crm.app.service;

import org.springframework.stereotype.Service;

import com.crm.app.entity.Utilisateur;

@Service
public interface UserService {
	
	Utilisateur createUser(Utilisateur user);

}
