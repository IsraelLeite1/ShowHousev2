package com.qintess.spring.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.qintess.spring.entities.pk.CartPK;

@Entity
@Table(name = "tb_cart")
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CartPK id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@MapsId("client")
	private Client client;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@MapsId("event")
	private Event event;

	@Column(name = "cart_item_qtd")
	private Integer qtd;

	@Column(name = "cart_item_subtotal")
	private Double subTotal;

	public Cart() {
		super();
		id = new CartPK();
	}

	public Cart(Client client, Event event, Integer qtd, Double subTotal) {
		super();
		this.client = client;
		this.event = event;
		this.qtd = qtd;
		this.subTotal = subTotal;
		this.id = new CartPK(client.getId(), event.getId());
	}

	public CartPK getId() {
		return id;
	}

	public void setId(CartPK id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
		id.setClient(client.getId());
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
		id.setEvent(event.getId());
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", client=" + client + ", event=" + event + ", qtd=" + qtd + ", subTotal="
				+ subTotal + "]";
	}

}
