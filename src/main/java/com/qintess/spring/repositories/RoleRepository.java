package com.qintess.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.spring.entities.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{
	
}
