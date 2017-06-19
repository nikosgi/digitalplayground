package com.dp.digip.models;

/**
 * 
 */
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Blob;
import java.util.Date;
import java.io.Serializable;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "parent")
public class Parent implements Serializable{


    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String surname;

//    @Column(unique = true, nullable = false)
//    private String fathers_name;

    @Column(unique = true, nullable = false)
    private String cellphone;

    @Column(unique = true, nullable = false)
    private String phone;

    @Column(unique = true, nullable = false)
    private String region;

    @Column(unique = true, nullable = false)
    private String municipality;

    @Column(unique = true, nullable = false)
    private String country;

    @Column(unique = false, nullable = false)
    private Date birthDate;

    //there are 2 types of Blob
    @Column(unique = true,nullable = true)
    private Blob participation_certificate;

    //there are 2 types of Blob
    @Column(unique = true, nullable = true)
    private Blob avatar;

    @Column(unique = true, nullable = false)
    private Integer money;

//    @Column(unique = true, nullable = false)
//    private String pass;

    @Id
    @OneToOne
    @JoinColumn(name="id")
    private User user;

    public Parent() { }

    public Parent( String name, String surname, String fathers_name,String cellphone, String phone, String region, String municipality,
                  String country, Blob participation_certificate, Blob avatar, Integer money)
    {
        this.name = name;
        this.surname = surname;
        this.cellphone = cellphone;
        this.phone = phone;
        this.region = region;
        this.municipality = municipality;
        this.country = country;
        this.participation_certificate = participation_certificate;
        this.avatar = avatar;
        this.money = money;
    }

    //SETTERS


    public void setName(String name1){
        name = name1;
    }

    public void setSurname(String surname1){
        surname = surname1;
    }


    public void setCellphone(String cellphone1){
        cellphone = cellphone1;
    }

    public void setPhone(String phone1){
        phone = phone1;
    }

    public void setRegion(String region1){
        region = region1;
    }

    public void setMunicipality(String municipality1){
        municipality = municipality1;
    }

    public void setCountry(String country1){
        country = country1;
    }

    public void setParticipation_certificate(Blob part_cert){
        participation_certificate = part_cert;
    }

    public void setAvatar(Blob avatar1){
        avatar = avatar1;
    }

    public void setMoney(Integer money1){
        money = money1;
    }


    public void setUser(User user1){
	this.user = user1;
    }


    //GETTERS

    public String getName( ){
        return name;
    }

    public String etSurname( ){
        return surname;
    }

    public String getCellphone( ){
        return cellphone;
    }

    public String getPhone( ){
        return phone;
    }

    public String getRegion( ){
        return region;
    }

    public String getMunicipality( ){
        return municipality;
    }

    public String getCountry( ){
        return country;
    }

    public Blob getParticipation_certificate( ){
        return participation_certificate;
    }

    public Blob getAvatar( ){
        return avatar;
    }

    public Integer getMoney( ){
        return money;
    }

    public User getUser(){
	return this.user;
    }

}
