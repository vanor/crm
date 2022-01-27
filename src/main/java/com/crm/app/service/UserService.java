package com.crm.app.service;

import com.crm.app.entity.Utilisateur;

public interface UserService {
	Utilisateur createUser(Utilisateur user);
	Utilisateur findById(Long id);
	Utilisateur findByLogin(String login);
}
