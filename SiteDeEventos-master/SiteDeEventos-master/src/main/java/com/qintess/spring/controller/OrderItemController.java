package com.qintess.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qintess.spring.entities.Event;
import com.qintess.spring.entities.Order;
import com.qintess.spring.entities.OrderItem;
import com.qintess.spring.services.EventService;
import com.qintess.spring.services.OrderItemService;
import com.qintess.spring.services.OrderService;

@Controller
@RequestMapping("/orderItem")
public class OrderItemController {
	
	private OrderItemService orderItemService;
	private EventService eventService;
	private OrderService orderService;
	
	@Autowired
	public OrderItemController(OrderItemService orderItemService, EventService eventService,
			OrderService orderService) {
		super();
		this.orderItemService = orderItemService;
		this.eventService = eventService;
		this.orderService = orderService;
	}

	@GetMapping("/showOrderItems")
	public String getOrderItems(Model model) {

		List<OrderItem> orderItems = orderItemService.getOrderItems();

		model.addAttribute("orderItems", orderItems);

		return "main";
	}

	@GetMapping("/showOrderItem")
	public String getOrderItem(@RequestParam("orderItemId") int orderItemId, Model model) {

		OrderItem orderItem = orderItemService.getOrderItem(orderItemId);

		model.addAttribute("orderItem", orderItem);

		return "orderItem-info";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(@RequestParam("eventId") int eventId,Model model) {
		OrderItem orderItem = new OrderItem();
		
		Event event = eventService.getEvent(eventId);
		orderItem.setEvent(event);

		model.addAttribute("orderItem", orderItem);

		return "order-form";
	}

	@PostMapping("/saveOrderItem")
	public String saveOrderItem(@ModelAttribute("orderItem") OrderItem orderItem) {
		
		Order order = new Order(null, 10.0, null);
		orderService.saveOrUpdateOrder(order);
		
		order = orderService.getOrder(1L);
		
		orderItem.setOrder(order);
		orderItemService.saveOrUpdateOrderItem(orderItem);
		return "redirect:/showHome";
	}

}
