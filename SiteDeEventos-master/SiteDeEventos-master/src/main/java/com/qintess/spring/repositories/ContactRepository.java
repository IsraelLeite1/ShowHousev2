package com.qintess.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.spring.entities.Contact;


public interface ContactRepository extends JpaRepository<Contact, Long>{
	
}
