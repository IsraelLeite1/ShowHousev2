package com.qintess.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.spring.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
