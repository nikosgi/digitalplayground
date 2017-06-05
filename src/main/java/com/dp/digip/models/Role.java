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


    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign", 
	parameters={
		@Parameter(name="property", value="user")
	}
    )
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String name;
    
    @Column(unique = true, nullable = false)
    private int role;

    @OneToOne(mappedBy="role", cascade = CascadeType.ALL)
    private User user;


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
