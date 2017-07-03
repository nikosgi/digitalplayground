package com.dp.digip.models.DTO;

/**
 * Created by Nikos on 21/5/2017.
 */

import java.util.Set;



import java.io.Serializable;
/**
 * An entity User composed by three fields (id, email, name).
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the name for the table in the db.
 *
 * @author netgloo
 */


public class UserObject implements Serializable{


    private  String password;

    private String password_confirmation;

    private String username;

    private String email;
    
    private String role;

    private byte[] image;


    public UserObject() { }

    
    public UserObject(String email,String username,String password,String role,byte[] image) {
        this.email = email;
        this.username = username; 
        this.password = password;
        this.image = image;
        this.role = role;
    }


    // Getter and setter methods

    public String getPassword(){ return this.password;}
    public void setPassword(String pass){ this.password = pass;}

    public String getPassword_confirmation(){ return this.password_confirmation; }
    public void setPassword_confiramtion(String password_confirmation) { this.password_confirmation = password_confirmation; }



    public String getEmail() {
        return email;
    }
    public void setEmail(String value) {
        this.email = value;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String value) {
        this.username = value;
    }
        

    public String getRole(){
	return this.role;
    }

    public void setRole(String role1){
	this.role = role1;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
