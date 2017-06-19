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
    private String role;

    @Id
    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    public Role() { }

    public Role(String role){this.role = role; }  

    public String getRole(){
	return this.role;
    }

    public void setRole(String role1){
	this.role = role1;
    }   

    public User getUser(){
	return this.user;
    }

    public void setUser(User user1){
	this.user = user1;
    }

} 
