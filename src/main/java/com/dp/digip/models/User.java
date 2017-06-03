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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private  String password;

    @NotNull
    private String name;

    @NotNull
    private String username;

    @NotNull
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Role role;


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

}
