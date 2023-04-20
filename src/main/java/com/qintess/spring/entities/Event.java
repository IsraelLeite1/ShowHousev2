package com.qintess.spring.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_event")
public class Event implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_id")
	private Long id;
	
	@Column(name = "event_name")
	private String name;
	
	@Column(name = "event_description")
	private String description;
	
	@Column(name = "event_date")
	private Date date;
	
	@Lob
	@Column(columnDefinition = "mediumblob")
	private byte[] imagemProd;
	
	@Column(name = "event_price")
	private Double price;
	
	@Column(name = "event_qtdTicket")
	private Integer qtdTicket;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "client_id")
	private Client client;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "house_id")
	private ShowHouse showHouse;
	
	@OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<OrderItem> orders = new HashSet<OrderItem>();
	
	@OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Cart> cartItens = new HashSet<Cart>();
	
	public Event() {}

	public Event(String name, String description, Date date, Double price, Integer qtdTicket, Client client,
			ShowHouse showHouse) {
		super();
		this.name = name;
		this.description = description;
		this.date = date;
		this.price = price;
		this.qtdTicket = qtdTicket;
		this.client = client;
		this.showHouse = showHouse;
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

	public ShowHouse getShowHouse() {
		return showHouse;
	}

	public void setShowHouse(ShowHouse showHouse) {
		this.showHouse = showHouse;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<OrderItem> getOrders() {
		return orders;
	}

	public void setItens(Set<OrderItem> orders) {
		this.orders = orders;
	}

	public Set<Cart> getCartItens() {
		return cartItens;
	}

	public void setCartItens(Set<Cart> cartItens) {
		this.cartItens = cartItens;
	}

	public void setOrders(Set<OrderItem> orders) {
		this.orders = orders;
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
