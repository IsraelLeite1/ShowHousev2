package com.qintess.spring.controller;

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

import com.qintess.spring.entities.ShowHouse;
import com.qintess.spring.entities.ShowHouse;
import com.qintess.spring.services.ShowHouseService;
import com.qintess.spring.services.ShowHouseService;

@Controller
@RequestMapping("/showHouse")
public class ShowHouseController {
	
	@Autowired
	private ShowHouseService showHouseService; 

	@GetMapping("/showShowHouses")
	public String getShowHouses(Model model) {

		List<ShowHouse> showHouses = showHouseService.getShowHouses();

		model.addAttribute("showHouses", showHouses);

		return "main";
	}

	@GetMapping("/showShowHouse")
	public String getShowHouse(@RequestParam("showhouseId") int showHouseId, Model model) {

		ShowHouse showHouse = showHouseService.getShowHouse(showHouseId);

		model.addAttribute("showHouse", showHouse);

		return "showHouse-info";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {

		ShowHouse showHouse = new ShowHouse();
		
		model.addAttribute("showHouse", showHouse);

		return "showHouse-form";
	}

	@PostMapping("/saveShowHouse")
	public String saveShowHouse(@ModelAttribute("showHouse") ShowHouse showHouse) {
		
		
		showHouseService.saveOrUpdateShowHouse(showHouse);

		return "redirect:/showHome";
	}

	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("showHouseId") int showHouseId, Model model) {

		ShowHouse showHouse = showHouseService.getShowHouse(showHouseId);

		model.addAttribute("showHouse", showHouse);

		return "showHouse-form";
	}

	@DeleteMapping("/deleteShowHouse")
	public String deleteShowHouse(@RequestParam("showHouseId") long id) {

		showHouseService.deleteShowHouse(id);

		return "redirect:/showHome";
	}

}
