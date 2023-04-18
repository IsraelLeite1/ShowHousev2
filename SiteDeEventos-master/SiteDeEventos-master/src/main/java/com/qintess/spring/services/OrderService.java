package com.qintess.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.spring.entities.Order;
import com.qintess.spring.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	public List<Order> getOrders() {
		return repository.findAll();
	}

	public void saveOrUpdateOrder(Order order) {
		repository.save(order);
	}

	public Order getOrder(long id) {
		Optional<Order> obj = repository.findById(id);

		return obj.get();
	}

	public void deleteOrder(Long id) {
		Optional<Order> obj = repository.findById(id);
		Order deletedOrder = obj.get();
		repository.delete(deletedOrder);
	}
	
}
