package com.qintess.spring.validation;

public class ShowHouseValidation {

	private Long id;

	private String name;

	private Integer capacity;

	public ShowHouseValidation() {
		super();
	}

	public ShowHouseValidation(String name, Integer capacity) {
		super();
		this.name = name;
		this.capacity = capacity;
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

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	
}
