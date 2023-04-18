package com.qintess.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qintess.spring.entities.Cart;
import com.qintess.spring.entities.Client;
import com.qintess.spring.entities.Event;
import com.qintess.spring.services.CartService;
import com.qintess.spring.services.ClientService;
import com.qintess.spring.services.EventService;

@Controller
@RequestMapping("/cart")
public class CartController {

	private EventService eventService;
	private CartService cartService;
	private ClientService clientService;

	@Autowired
	public CartController(EventService eventService, CartService cartService, ClientService clientService) {
		super();
		this.eventService = eventService;
		this.cartService = cartService;
		this.clientService = clientService;
	}
	
	@GetMapping("/showCart")
	public String getCart(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Client client = clientService.findByUsername(name);
		List<Cart> cart = cartService.getClientCarts(client);
		List<Event> events = new ArrayList<Event>();
		for (Cart c : cart) {
			events.add(c.getEvent());
		}
		
		model.addAttribute("events", events);
		model.addAttribute("cart", cart);

		return "cart";
	}

	@GetMapping("/showInfo")
	public String getEvent(@RequestParam("eventId") int eventId, Model model) {

		Event event = eventService.getEvent(eventId);

		model.addAttribute("event", event);

		return "event-info";
	}

	@GetMapping("/showOrderForm")
	public String showOrderForm(@RequestParam("eventId") int eventId, Model model) {
		Cart cart = new Cart();
		Event event = eventService.getEvent(eventId);
		
		cart.setEvent(event);
		
		model.addAttribute("event", event);
		model.addAttribute("cart", cart);

		return "order-form";
	}

	@PostMapping("/putInCart")
	public String putInCart(@ModelAttribute("cart") Cart cart) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Client client = clientService.findByUsername(name);
		cart.setSubTotal(cart.getEvent().getPrice());		
		cart.setClient(client);
		if(cartService.saveOrUpdateCart(cart)) {
			return "redirect:/showHome";
		}else {
			return "redirect:/cart/showOrderForm?eventId="+cart.getEvent().getId();
		}
		
		
	}

}
