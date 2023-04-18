package com.qintess.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.spring.entities.Cart;
import com.qintess.spring.entities.Client;
import com.qintess.spring.entities.Event;
import com.qintess.spring.repositories.CartRepository;
import com.qintess.spring.repositories.EventRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository repository;
	
	private EventService eventService;

	public List<Cart> getClientCarts(Client client) {
		
		return repository.findClientCart(client);
	}

	public boolean saveOrUpdateCart(Cart cart) {
		Event event = cart.getEvent();
		if((event.getQtdTicket() - cart.getQtd()) < 0 || cart.getQtd() > 4) {
			return false;
		}else {
			event.setQtdTicket(event.getQtdTicket() - cart.getQtd());
			repository.save(cart);
			return true;
		}
		
	}

	public Cart getCart(long id) {
		Optional<Cart> obj = repository.findById(id);

		return obj.get();
	}

	public void deleteCart(Long id) {
		Optional<Cart> obj = repository.findById(id);
		Cart deletedCart = obj.get();
		repository.delete(deletedCart);
	}
}
