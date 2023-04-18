package com.qintess.spring.entities.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CartPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "client_id")
	private Long client;

	@Column(name = "event_id")
	private Long event;

	public CartPK() {
		super();
	}

	public CartPK(Long client, Long event) {
		super();
		this.client = client;
		this.event = event;
	}

	public Long getClient() {
		return client;
	}

	public void setClient(Long client) {
		this.client = client;
	}

	public Long getEvent() {
		return event;
	}

	public void setEvent(Long event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "CartPK [client=" + client + ", event=" + event + "]";
	}

}