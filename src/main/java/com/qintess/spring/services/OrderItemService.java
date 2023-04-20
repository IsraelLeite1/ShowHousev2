package com.qintess.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.spring.entities.OrderItem;
import com.qintess.spring.repositories.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository repository;

	public List<OrderItem> getOrderItems() {
		return repository.findAll();
	}

	public void saveOrUpdateOrderItem(OrderItem orderItem) {
		repository.save(orderItem);
	}

	public OrderItem getOrderItem(long id) {
		Optional<OrderItem> obj = repository.findById(id);

		return obj.get();
	}

	public void deleteOrderItem(Long id) {
		Optional<OrderItem> obj = repository.findById(id);
		OrderItem deletedOrderItem = obj.get();
		repository.delete(deletedOrderItem);
	}
	
}
