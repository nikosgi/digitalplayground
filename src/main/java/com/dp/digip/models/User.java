package com.dp.digip.models;

/**
 * Created by Nikos on 21/5/2017.
 */
import javax.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.Set;


import com.dp.digip.models.DTO.UserObject;
import java.io.Serializable;
/**
 * An entity User composed by three fields (id, email, name).
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the name for the table in the db.
 *
 * @author netgloo
 */

@Entity
@Table(name = "user")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( unique = true,nullable = false)
    private Long id;

    @Column( unique = true,nullable = false)
    private  String password;

    @Transient
    private String role_temp;

    @Column( unique = true,nullable = false)
    private String username;

    @Column( unique = true,nullable = true)
    private String email=null;
    
    @OneToOne(cascade=CascadeType.ALL, mappedBy="user") 
    private Role role;

    @OneToOne(cascade=CascadeType.ALL, mappedBy="user")
    private Parent parent;

    @OneToOne(cascade=CascadeType.ALL, mappedBy="user")
    private Provider provider;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Event> events;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Transaction> transactions;

    public User() { }

    public User(long id) {
        this.id = id;
    }


    public User(String email,String username,String password,Role role) {
        this.email = email;
        this.username = username; 
        this.password = password;

        this.role = role;
        this.role.setUser(this);
    }

    public User(String email,String username,String password,Role role,Provider provider) {
        this.email = email;
	this.username = username;
	this.password = password;
	
	this.role = role;
	this.role.setUser(this);
	
	this.provider = provider;
	this.provider.setUser(this);
    }

    public User(String email,String username,String password,Role role,Parent parent) {
        this.email = email;
        this.username = username;
        this.password = password;

        this.role = role;
        this.role.setUser(this);

        this.parent = parent;
        this.parent.setUser(this);
    }



    // Getter and setter methods

    public String getPassword(){ return this.password;}
    public void setPassword(String pass){ this.password = pass;}

    public String getRole_temp(){ return this.role_temp;}
    public void setRole_temp(String role_temp) {this.role_temp = role_temp; }


    public String getEmail() {
        return this.email;
    }
    public void setEmail(String value) {
        this.email = value;
    }

    public String getUsername() {
        return this.username;
    }
    public void setUsername(String value) {
        this.username = value;
    }
        

    public Role getRole(){
	return this.role;
    }

    public void setRole(Role role1){
	this.role = role1;
    }

    public Parent getParent(){
	return this.parent;
    }

    public void setParent(Parent parent1){
   	this.parent = parent;
    }

    public Provider getProvider(){
	return this.provider;
    }


    public void setProvider(Provider provider1){
	this.provider = provider1;
    }

    public Set<Event> getEvents(){
	return this.events;
    }

    public void setEvents(Set<Event> events){
	this.events= events;
    }

    public Set<Transaction> getTransactions(){
	return this.transactions;
    }	

    public void setTransactions( Set<Transaction> transaction){
	this.transactions = transaction;
    }


}
