package com.qintess.spring.validation;

import java.util.Date;

import com.qintess.spring.entities.ShowHouse;

public class EventValidation {
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private String date;
	
	private Double price;
	
	private Integer qtdTicket;
	
	private String photo;
	
	private ShowHouse showHouse;
	
	private byte[] imagemProd;
	
	public EventValidation() {}

	public EventValidation(String name, String description, String date, Double price, Integer qtdTicket) {
		super();
		this.name = name;
		this.description = description;
		this.date = date;
		this.price = price;
		this.qtdTicket = qtdTicket;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQtdTicket() {
		return qtdTicket;
	}

	public void setQtdTicket(Integer qtdTicket) {
		this.qtdTicket = qtdTicket;
	}
	
	public ShowHouse getShowHouse() {
		return showHouse;
	}

	public void setShowHouse(ShowHouse showHouse) {
		this.showHouse = showHouse;
	}

	public byte[] getImagemProd() {
		return imagemProd;
	}

	public void setImagemProd(byte[] imagemProd) {
		this.imagemProd = imagemProd;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", description=" + description + ", date="
				+ date + ", price=" + price + ", qtdTicket=" + qtdTicket + "]";
	}
	
	
}
