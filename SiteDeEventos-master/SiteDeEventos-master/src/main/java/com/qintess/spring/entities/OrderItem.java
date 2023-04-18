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

import com.qintess.spring.entities.pk.OrderItemPK;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemPK id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@MapsId("order")
	private Order order;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@MapsId("event")
	private Event event;
	
	@Column(name = "order_item_qtd")
	private Integer qtd;
	
	@Column(name = "order_item_subtotal")
	private Double subTotal;
	
	public OrderItem() {
		super();
		id = new OrderItemPK();
	}

	public OrderItem(Order order, Event event, Integer qtd, Double subTotal) {
		super();
		this.order = order;
		this.event = event;
		this.qtd = qtd;
		this.subTotal = subTotal;
		this.id = new OrderItemPK(order.getId(), event.getId());
	}

	public OrderItemPK getId() {
		return id;
	}

	public void setId(OrderItemPK id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
		id.setOrder(order.getId());
		
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
		return "OrderItem [id=" + id + ", order=" + order + ", event=" + event + ", qtd=" + qtd + ", subTotal="
				+ subTotal + "]";
	}
	
	
}
