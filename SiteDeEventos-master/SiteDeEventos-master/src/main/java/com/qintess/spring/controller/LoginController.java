package com.qintess.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.qintess.spring.entities.Event;
import com.qintess.spring.services.EventService;

@Controller
public class LoginController {
	
	@Autowired
	private EventService eventService;
	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "plain-login";
	}

	@GetMapping("/")
	public String showMainPage(Model model) {
		List<Event> events = eventService.getEvents();

		model.addAttribute("events", events);
		
		return "index";
	}

	@GetMapping("/showHome")
	public String getEvents(Model model) {

		List<Event> events = eventService.getEvents();

		model.addAttribute("events", events);

		return "main";
	}
}
