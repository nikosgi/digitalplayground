package com.dp.digip.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

@Entity
public class Transaction{

	@Id
    	@GeneratedValue(strategy = GenerationType.AUTO)
        @Column( unique = true,nullable = false)
	private Long id;


	@Column(nullable = false,unique = false)
	private int number_of_tickets;

	
	@JoinColumn(name = "user_id",nullable = false,unique = false, referencedColumnName = "id")
	@ManyToOne
	private User user;

	@JoinColumn(name ="event_id",nullable = false,unique = false,referencedColumnName = "id")
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

	public User getUser(){
		return this.user;
	}

	public void setUser(User user){
		this.user = user;
	}

	public Event getEvent(){
		return this.event;
	}
	
	public void setEvent(Event event){
		this.event = event;
	}

}  
