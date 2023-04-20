package com.qintess.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.spring.entities.ShowHouse;
import com.qintess.spring.repositories.ShowHouseRepository;

@Service
public class ShowHouseService {

	@Autowired
	private ShowHouseRepository repository;

	public List<ShowHouse> getShowHouses() {
		return repository.findAll();
	}

	public void saveOrUpdateShowHouse(ShowHouse showHouse) {
		repository.save(showHouse);
	}

	public ShowHouse getShowHouse(long id) {
		Optional<ShowHouse> obj = repository.findById(id);

		return obj.get();
	}

	public void deleteShowHouse(Long id) {
		Optional<ShowHouse> obj = repository.findById(id);
		ShowHouse deletedShowHouse = obj.get();
		repository.delete(deletedShowHouse);
	}
}
