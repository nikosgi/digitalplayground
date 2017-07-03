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
import com.dp.digip.models.DTO.ParentObject;


@Entity
@Table(name = "parent")
public class Parent implements Serializable{


    @Column(unique = false, nullable = false)
    private String name;

    @Column(unique = false, nullable = false)
    private String surname;

//    @Column(unique = true, nullable = false)
//    private String fathers_name;

    @Column(unique = true, nullable = false)
    private String cellphone;

    @Column(unique = true, nullable = false)
    private String phone;

    @Column(unique = false, nullable = false)
    private String region;

    @Column(unique = false, nullable = false)
    private String municipality;

    @Column(unique = false, nullable = false)
    private String country;

    @Column(unique = false, nullable = false)
    private Date birthDate;

    //there are 2 types of Blob
    @Column(unique = true,nullable = true)
    private Blob participation_certificate;

    //there are 2 types of Blob
    @Column(unique = false, nullable = true)
    private Blob avatar;

    @Column(unique = false, nullable = false)
    private Integer money;

//    @Column(unique = true, nullable = false)
//    private String pass;

    @Id
    @OneToOne
    @JoinColumn(name="id")
    private User user;

    public Parent() { }

    public Parent(ParentObject parent){
	
	this.name = parent.getName();
	this.surname = parent.getSurname();
	this.cellphone = parent.getCellphone();
	this.phone = parent.getPhone();
	this.region = parent.getRegion();
	this.municipality = parent.getMunicipality();
	this.country = parent.getCountry();
	this.birthDate = parent.getBirthDate();
	this.money = parent.getMoney();

    }


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
        this.name = name1;
    }

    public void setSurname(String surname1){
        this.surname = surname1;
    }


    public void setCellphone(String cellphone1){
        this.cellphone = cellphone1;
    }

    public void setPhone(String phone1){
        this.phone = phone1;
    }

    public void setRegion(String region1){
        this.region = region1;
    }

    public void setMunicipality(String municipality1){
        this.municipality = municipality1;
    }

    public void setCountry(String country1){
        this.country = country1;
    }

    public void setParticipation_certificate(Blob part_cert){
        this.participation_certificate = part_cert;
    }

    public void setAvatar(Blob avatar1){
        this.avatar = avatar1;
    }

    public void setMoney(Integer money1){
        this.money = money1;
    }


    public void setUser(User user1){
	this.user = user1;
    }


    //GETTERS

    public String getName( ){
        return this.name;
    }

    public String getSurname( ){
        return this.surname;
    }

    public String getCellphone( ){
        return this.cellphone;
    }

    public String getPhone( ){
        return this.phone;
    }

    public String getRegion( ){
        return this.region;
    }

    public String getMunicipality( ){
        return this.municipality;
    }

    public String getCountry( ){
        return this.country;
    }

    public Blob getParticipation_certificate( ){
        return this.participation_certificate;
    }

    public Blob getAvatar( ){
        return this.avatar;
    }
    public Date getBirthDate(){
        return this.birthDate;
    }
    public Integer getMoney( ){
        return this.money;
    }

    public User getUser(){
	return this.user;
    }

}
