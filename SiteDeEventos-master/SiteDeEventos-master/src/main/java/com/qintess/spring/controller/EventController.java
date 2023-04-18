package com.qintess.spring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qintess.spring.entities.Event;
import com.qintess.spring.entities.ShowHouse;
import com.qintess.spring.services.EventService;
import com.qintess.spring.services.ShowHouseService;
import com.qintess.spring.validation.EventValidation;

@Controller
@RequestMapping("/event")
public class EventController {

	private EventService eventService;
	private ShowHouseService showHouseService; 
	
	
	@Autowired
	public EventController(EventService eventService, ShowHouseService showHouseService) {
		super();
		this.eventService = eventService;
		this.showHouseService = showHouseService;
	}

	@GetMapping("/showEvents")
	public String getEvents(Model model) {

		List<Event> events = eventService.getEvents();

		model.addAttribute("events", events);

		return "main";
	}

	@GetMapping("/showEvent")
	public String getEvent(@RequestParam("eventId") int eventId, Model model) {

		Event event = eventService.getEvent(eventId);

		model.addAttribute("event", event);

		return "event-info";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model, Model modelShowHouse) {

		EventValidation event = new EventValidation();
		List<ShowHouse> showHouses = showHouseService.getShowHouses();
		
		model.addAttribute("showHouses", showHouses);
		model.addAttribute("event", event);

		return "event-form";
	}
	
	@GetMapping("/buyEvent")
	public String buyEvent(@RequestParam("eventId") int eventId, Model model) {

		Event event = eventService.getEvent(eventId);
		
		model.addAttribute("event", event);

		return "order-form";
	}

	@PostMapping("/saveEvent")
	public String saveEvent(@ModelAttribute("event") EventValidation eventV) {
		 
		Event event = new Event();
		
		event.setName(eventV.getName());
		event.setDescription(eventV.getDescription());
		event.setPrice(eventV.getPrice());
		event.setQtdTicket(eventV.getQtdTicket());
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(eventV.getDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		event.setDate(date);
		eventService.saveOrUpdateEvent(event);

		return "redirect:/showHome";
	}

	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("eventId") int eventId, Model model) {

		Event event = eventService.getEvent(eventId);

		model.addAttribute("event", event);

		return "event-form";
	}

	@DeleteMapping("/deleteEvent")
	public String deleteEvent(@RequestParam("showHouseId") long id) {

		eventService.deleteEvent(id);

		return "redirect:/showHome";
	}

}
