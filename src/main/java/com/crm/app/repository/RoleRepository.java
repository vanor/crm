package com.crm.app.repository;

import com.crm.app.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	@Query(value = "SELECT * FROM role order by id desc limit 1", 
			  nativeQuery = true)
	Role findLastRole();
}
