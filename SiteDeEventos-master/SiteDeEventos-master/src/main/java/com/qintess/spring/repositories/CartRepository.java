package com.qintess.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qintess.spring.entities.Cart;
import com.qintess.spring.entities.Client;


public interface CartRepository extends JpaRepository<Cart, Long>{
	
	@Query("FROM Cart WHERE client = ?1")
	List<Cart> findClientCart(Client client);
}
