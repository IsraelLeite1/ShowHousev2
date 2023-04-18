package com.qintess.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.spring.entities.Role;
import com.qintess.spring.repositories.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository repository;
	
	public Role findByName(String roleName) {
		List<Role> roles = repository.findAll();
		Role role = null;
		for (Role r : roles) {
			if(r.getName().equals(roleName))
				role = r;
		}
		if (role == null) {
			throw new RuntimeException();
		}
		return role;
	}
}
