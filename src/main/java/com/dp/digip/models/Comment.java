package com.dp.digip.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Comment {

	@Id 
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column( unique = true,nullable = false)
        private Long id;

	@Column( unique = false,nullable= false)
	private String body;

	@Column ( unique = false, nullable = false)
	private int rating;
	
        @Temporal(TemporalType.DATE)
        @Column( unique = false, nullable = false)
        private Date date;
	
	
        @JoinColumn(name = "user_id",nullable = false,unique = false, referencedColumnName = "id")
        @ManyToOne
        private User user;

        @JoinColumn(name ="event_id",nullable = false,unique = false,referencedColumnName = "id")
        @ManyToOne
        private Event event;

	public Comment(){}

	public Comment( String body , int rating, Date date , User user, Event event){
		this.body = body;
		this.rating = rating;
		this.date = date;
		this.user = user;
		this.event = event;
	}		

	public String getBody(){
		return this.body;
	}

	public void setBody(String body){
		this.body = body;
	}

	public int getRating(){
		return this.rating;
	}

	public void setRating(int rating){
		this.rating = rating;
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

        public Date getDate() {
                return date;
        }

        public void setDate(Date date) {
                this.date = date;
        }










}
