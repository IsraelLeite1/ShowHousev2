package com.qintess.spring.entities.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderItemPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "order_id")
	private Long order;

	@Column(name = "event_id")
	private Long event;

	public OrderItemPK() {
		super();
	}

	public OrderItemPK(Long order, Long event) {
		super();
		this.order = order;
		this.event = event;
	}

	public Long getOrder() {
		return order;
	}

	public void setOrder(Long order) {
		this.order = order;
	}

	public Long getEvent() {
		return event;
	}

	public void setEvent(Long event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "OrderItemPK [order=" + order + ", event=" + event + "]";
	}

	

}
