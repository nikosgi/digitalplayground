package com.dp.digip.models;

/**
 * Created by Christos on 24/5/2017.
 */
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Blob;
import java.io.Serializable;
import java.util.Set;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name = "provider")
public class Provider implements Serializable{

    @Column(unique = true, nullable = false)
    private String sector_type;

    @Column(unique = true, nullable = false)
    private String brand_name;

    @Column(unique = true, nullable = false)
    private String distinctive_title;

    @Column(unique = true, nullable = false)
    private String tax_identification_number;

    @Column(unique = true, nullable = false)
    private String public_finance_agency;

    @Column(unique = true, nullable = false)
    private String country;

    @Column(unique = true, nullable = false)
    private String address;

    @Column(unique = true, nullable = false)
    private String address_number;

    @Column(unique = true, nullable = false)
    private String postal_code;

    @Column(unique = true, nullable = false)
    private String region;

    @Column(unique = true, nullable = false)
    private String municipality;

    @Column(unique = true, nullable = false)
    private String legal_represantation;

    @Column(unique = true, nullable = false)
    private String legal_represantation_phone;

    @Column(unique = true, nullable = false)
    private String legal_represantation_email;

    @Column(unique = true)
    private Blob participation_certificate;

    @Column(unique = true)
    private Blob identification_document;

    @Column(unique = true)
    private Blob avatar;

    @Id
    @OneToOne
    @JoinColumn(name="id") 
    private User user;



    public Provider() { }

    public Provider(String sector_type, String brand_name, String distinctive_title, String tax_identification_number,
                    String public_finance_agency, String country, String address, String address_number, String postal_code,
                    String region, String municipality, String legal_represantation, String legal_represantation_phone,
                    String legal_represantation_email, Blob participation_certificate, Blob identification_document, Blob avatar)
    {
        this.sector_type = sector_type;
        this.brand_name = brand_name;
        this.distinctive_title = distinctive_title;
        this.tax_identification_number = tax_identification_number;
        this.public_finance_agency = public_finance_agency;
        this.country = country;
        this.address = address;
        this.address_number = address_number;
        this.postal_code = postal_code;
        this.region = region;
        this.municipality = municipality;
        this.legal_represantation = legal_represantation;
        this.legal_represantation_phone = legal_represantation_phone;
        this.legal_represantation_email = legal_represantation_email;
        this.participation_certificate = participation_certificate;
        this.identification_document = identification_document;
        this.avatar = avatar;

    }


    //SETTERS

    public void setSector_type(String sector_type1){
        sector_type = sector_type1;
    }

    public void setBrand_name(String brand_name1){
        brand_name = brand_name1;
    }

    public void setDistinctive_title(String distinctive_title1){
        distinctive_title = distinctive_title1;
    }

    public void setTax_identification_number(String tax_identification_number1){
        tax_identification_number = tax_identification_number1;
    }

    public void setPublic_finance_agency(String public_finance_agency1){
        public_finance_agency = public_finance_agency1;
    }

    public void setCountry(String country1){
        country = country1;
    }

    public void setAddress(String address1){
        address = address1;
    }

    public void setAddress_number(String address_number1){
        address_number = address_number1;
    }

    public void setPostal_code(String postal_code1){
        postal_code = postal_code1;
    }

    public void setRegion(String region1){
        region = region1;
    }

    public void setMunicipality(String municipality1){
        municipality = municipality1;
    }

    public void setLegal_represantation(String legal_represantation1){
        legal_represantation = legal_represantation1;
    }

    public void setLegal_represantation_phone(String legal_represantation_phone1){
        legal_represantation_phone = legal_represantation_phone1;
    }

    public void setLegal_represantation_email(String legal_represantation_email1){
        legal_represantation_email = legal_represantation_email1;
    }

    public void setParticipation_certificate(Blob participation_certificate1){
        participation_certificate = participation_certificate1;
    }

    public void setIdentification_document(Blob identification_document1){
        identification_document = identification_document1;
    }

    public void setAvatar(Blob avatar1){
        avatar = avatar1;
    }

    public void setUser(User user1){
	this.user = user1;
    }

    //GETTERS

    public String getSector_type(){
        return sector_type;
    }

    public String getBrand_name(){
        return brand_name;
    }

    public String getDistinctive_title(){
        return distinctive_title;
    }

    public String getTax_identification_number(){
        return tax_identification_number;
    }

    public String getPublic_finance_agency(){
        return public_finance_agency;
    }

    public String getCountry(){
        return country;
    }

    public String getAddress(){
        return address;
    }

    public String getAddress_number(){
        return address_number;
    }

    public String getPostal_code(){
        return postal_code;
    }

    public String getRegion(){
        return region;
    }

    public String getMunicipality(){
        return municipality;
    }

    public String getLegal_represantation(){
        return legal_represantation;
    }

    public String getLegal_represantation_phone(){
        return legal_represantation_phone;
    }

    public String getLegal_represantation_email(){
        return legal_represantation_email;
    }

    public Blob getParticipation_certificate(){
        return participation_certificate;
    }

    public Blob getIdentification_document(){
        return identification_document;
    }

    public Blob getAvatar(){
        return avatar;
    }

    public User getUser(){
	return this.user;
    }

}
