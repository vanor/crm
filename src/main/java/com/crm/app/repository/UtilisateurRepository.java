package com.crm.app.repository;


import com.crm.app.entity.Groupe;
import com.crm.app.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    List<Utilisateur> findAllByGroupesIsNot(Groupe groupe);
    Utilisateur findByLogin(String login); 
  //  List<Utilisateur> findByGroupesIsAndRoleIn(java.util.Set<Groupe> groupes, String role);
  //  List<Utilisateur> findAllByGroupesIsAndIdNotIn(java.util.Set<Groupe> groupes, Long utilisateurId);
    List<Utilisateur> findAllByFcmToken(String fcmToken);

    List<Utilisateur> findAllBySupervisor(Utilisateur user);
    Utilisateur findFirstByRole(String role);
}
