package com.dp.digip.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name = "role")
public class Role implements Serializable{

    
    @Column(unique = false, nullable = false)
    private int role;

    @Id
    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    public Role() { }

    public Role(int role){this.role = role; }  

    public int getRole(){
	return this.role;
    }

    public void setRole(int role1){
	this.role = role1;
    }   

    public User getUser(){
	return this.user;
    }

    public void setUser(User user1){
	this.user = user1;
    }

} 
