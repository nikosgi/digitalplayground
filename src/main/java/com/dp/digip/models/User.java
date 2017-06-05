package com.dp.digip.models;

/**
 * Created by Nikos on 21/5/2017.
 */
import javax.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.Set;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( unique = true,nullable = false)
    private Long id;

    @Column( unique = true,nullable = false)
    private  String password;

    @Column( unique = true,nullable = false)
    private String name;

    @Column( unique = true,nullable = false)
    private String username;

    @Column( unique = true,nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)  
    @PrimaryKeyJoinColumn
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Parent parent;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Provider provider;

    public User() { }

    public User(long id) {
        this.id = id;
    }

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    // Getter and setter methods

    public String getPassword(){ return password;}
    public void setPassword(String pass){ this.password = pass;}

    public long getId() {
        return id;
    }
    public void setId(long value) {
        this.id = value;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String value) {
        this.email = value;
    }

    public String getName() {
        return name;
    }
    public void setName(String value) {
        this.name = value;
    }

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

    public void setProvider(Provider provider1){
	this.provider = provider1;
    }

}
