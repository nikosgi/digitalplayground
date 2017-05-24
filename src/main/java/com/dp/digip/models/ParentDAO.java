package com.dp.digip.models;

import java.sql.Blob;

/**
 * Created by Christos on 24/5/2017.
 */
public interface ParentDAO {

    Parent parent(String email, String name, String surname, String fathers_name, String pass,
                  String cellphone, String phone, String region, String municipality,
                  String country, Blob participation_certificate, Blob avatar, Integer money);



    //SETTERS
    void setId(Long id1);
    void setEmail(String email1);
    void setName(String name1);
    void setSurname(String surname1);
    void setFathers_name(String fathers_name1);
    void setCellphone(String cellphone1);
    void setPhone(String phone1);
    void setRegion(String region1);
    void setMunicipality(String municipality1);
    void setCountry(String country1);
    void setParticipation_certificate(Blob part_cert);
    void setAvatar(Blob avatar1);
    void setMoney(Integer money1);
    void setPass(String pass1);


    //GETTERS
    Long getId();
    String getEmail();
    String getName( );
    String etSurname( );
    String getFathers_name( );
    String getCellphone( );
    String getPhone( );
    String getRegion( );
    String getMunicipality( );
    String getCountry( );
    Blob getParticipation_certificate( );
    Blob getAvatar( );
    Integer getMoney( );
    String getPass( );
}
