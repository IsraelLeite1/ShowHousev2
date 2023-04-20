package com.qintess.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.spring.entities.Event;


public interface EventRepository extends JpaRepository<Event, Long>{
	
}
