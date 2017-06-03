package com.dp.digip.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

@Entity
@Table(name = "role")
public class Role implements Serializable{
    private Long id;
    private String name;
    private int role;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
} 
