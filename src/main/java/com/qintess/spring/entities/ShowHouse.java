package com.qintess.spring.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_show_house")
public class ShowHouse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "house_id")
	private Long id;

	@Column(name = "house_name")
	private String name;

	@Column(name = "house_capacity")
	private Integer capacity;

	@OneToMany(mappedBy = "showHouse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Event> events = new HashSet<Event>();

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "client_id")
	private Client client;

	public ShowHouse() {
		super();
	}

	public ShowHouse(String name, Integer capacity, Client client) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.client = client;
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


	public Set<Event> getEvents() {
		return events;
	}


	public void setEvents(Set<Event> events) {
		this.events = events;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}



	@Override
	public String toString() {
		return "ShowHouse [id=" + id + ", name=" + name + ", capacity=" + capacity + ", events=" + events + ", client="
				+ "client " + "]";
	}
	

}
