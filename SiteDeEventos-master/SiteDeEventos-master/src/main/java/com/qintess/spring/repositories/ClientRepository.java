package com.qintess.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.spring.entities.Client;


public interface ClientRepository extends JpaRepository<Client, Long>{
	
}
