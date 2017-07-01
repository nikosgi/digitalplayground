package com.dp.digip.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

@Entity
public class Transaction{

	@EmbeddedId
	private TransactionId id; 

	@Column(nullable = false)
	private int number_of_tickets;

	@MapsId("userId")
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@ManyToOne
	private User user;

	@MapsId("eventId")
	@JoinColumn(name ="event_id",referencedColumnName = "id")
	@ManyToOne
	private Event event;

	public Transaction(){}

	public Transaction( int number_of_tickets , User user , Event event ){
		this.number_of_tickets = number_of_tickets;
		this.user = user;
		this.event = event;
	}	

	public int getNumber_of_tickets(){
		return this.number_of_tickets;
	}
	public void setNumber_of_tickets( int number_of_tickets ){
		this.number_of_tickets = number_of_tickets ;
	}


}  
