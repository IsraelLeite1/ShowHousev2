package com.qintess.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.spring.entities.Event;
import com.qintess.spring.repositories.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;

	public List<Event> getEvents() {
		return repository.findAll();
	}

	public void saveOrUpdateEvent(Event Event) {
		repository.save(Event);
	}

	public Event getEvent(long id) {
		Optional<Event> obj = repository.findById(id);

		return obj.get();
	}

	public void deleteEvent(Long id) {
		Optional<Event> obj = repository.findById(id);
		Event deletedEvent = obj.get();
		repository.delete(deletedEvent);
	}
}
