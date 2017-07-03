package com.dp.digip.models.DTO;

import java.sql.Blob;
import java.util.Date;
import java.io.Serializable;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


public class ParentObject implements Serializable{


    private String name;

    private String surname;

//    @Column(unique = true, nullable = false)
//    private String fathers_name;

    private String cellphone;

    private String phone;

    private String region;

    private String municipality;

    private String country;

    private Date birthDate;

    private Blob participation_certificate;

    private Blob avatar;

    private Integer money;

//    @Column(unique = true, nullable = false)
//    private String pass;

    public ParentObject() { }

    public ParentObject( String name, String surname, String fathers_name,String cellphone, String phone, String region, String municipality,
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

    public void setBirthDate(Date birthdate){
    this.birthDate = birthdate;
    
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

    public Date getBirthDate(){
        return this.birthDate;

    }

    public Blob getParticipation_certificate( ){
        return this.participation_certificate;
    }

    public Blob getAvatar( ){
        return this.avatar;
    }

    public Integer getMoney( ){
        return this.money;
    }

}
