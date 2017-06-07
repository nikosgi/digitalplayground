package com.dp.digip.models;

/**
 * Created by Nikos on 21/5/2017.
 */
import javax.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.Set;
<<<<<<< HEAD

=======
import java.io.Serializable;
/**
 * An entity User composed by three fields (id, email, name).
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the name for the table in the db.
 *
 * @author netgloo
 */
>>>>>>> petros_pant
@Entity
@Table(name = "user")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( unique = true,nullable = false)
    private Long id;

<<<<<<< HEAD
    @NotNull
    private  String password;

    @NotNull
    private String name;

    @NotNull
=======
    @Column( unique = true,nullable = false)
    private  String password_hash;

    @Column( unique = true,nullable = false)
    private String salt;

    @Column( unique = true,nullable = false)
    private String username;

    @Column( unique = true,nullable = false)
>>>>>>> petros_pant
    private String email;
    
    @OneToOne(cascade=CascadeType.ALL, mappedBy="user") 
    private Role role;

    @OneToOne(cascade=CascadeType.ALL, mappedBy="user")
    private Parent parent;

    @OneToOne(cascade=CascadeType.ALL, mappedBy="user")
    private Provider provider;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Event> events;

<<<<<<< HEAD
=======

>>>>>>> petros_pant
    public User() { }

    public User(long id) {
        this.id = id;
    }

    public User(String email,String salt,String username,String password_hash,Role role) {
        this.email = email;
        this.username = username;
        this.salt = salt;
        this.password_hash = password_hash;

        this.role = role;
        this.role.setUser(this);
    }

    public User(String email,String salt,String username,String password_hash,Role role,Provider provider) {
        this.email = email;
	this.username = username;
	this.salt = salt;
	this.password_hash = password_hash;
	
	this.role = role;
	this.role.setUser(this);
	
	this.provider = provider;
	this.provider.setUser(this);
    }

    public User(String email,String salt,String username,String password_hash,Role role,Parent parent) {
        this.email = email;
        this.username = username;
        this.salt = salt;
        this.password_hash = password_hash;

        this.role = role;
        this.role.setUser(this);

        this.parent = parent;
        this.parent.setUser(this);
    }



    // Getter and setter methods

    public String getPassword_hash(){ return this.password_hash;}
    public void setPassword_hash(String pass){ this.password_hash = pass;}

    public String getSalt(){ return this.salt; }
    public void setSalt(String salt) { this.salt = salt; }

    public String getEmail() {
        return email;
    }
    public void setEmail(String value) {
        this.email = value;
    }

<<<<<<< HEAD
    public String getName() {
        return name;
    }
    public void setName(String value) {
        this.name = value;
    }




=======
    public String getUsername() {
        return username;
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
>>>>>>> petros_pant

    public void setProvider(Provider provider1){
	this.provider = provider1;
    }

    public Set<Event> getEvents(){
	return this.events;
    }

    public void setEvents(Set<Event> events){
	this.events= events;
    }
	


}
