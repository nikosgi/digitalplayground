package com.dp.digip.models.DAO;

import com.dp.digip.models.Provider;

import java.sql.Blob;

/**
 * Created by Christos on 24/5/2017.
 */
public interface ProviderDAO {

    Provider provider(String sector_type, String brand_name, String distinctive_title, String tax_identification_number,
                      String public_finance_agency, String country, String address, String address_number, String postal_code,
                      String region, String municipality, String legal_represantation, String legal_represantation_phone, String legal_represantation_email,
                      Blob participation_certificate, Blob identification_document, Blob avatar);


    //SETTERS
    void setSector_type(String sector_type1);
    void setBrand_name(String brand_name1);
    void setDistinctive_title(String distinctive_title1);
    void setTax_identification_number(String tax_identification_number1);
    void setPublic_finance_agency(String public_finance_agency1);
    void setCountry(String country1);
    void setAddress(String address1);
    void setAddress_number(String address_number1);
    void setPostal_code(String postal_code1);
    void setRegion(String region1);
    void setMunicipality(String municipality1);
    void setLegal_represantation(String legal_represantation1);
    void setLegal_represantation_phone(String legal_represantation_phone1);
    void setLegal_represantation_email(String legal_represantation_email1);
    void setParticipation_certificate(Blob participation_certificate1);
    void setIdentification_document(Blob identification_document1);
    void setAvatar(Blob avatar1);


    //GETTERS
    String getSector_type();
    String getBrand_name();
    String getDistinctive_title();
    String getTax_identification_number();
    String getPublic_finance_agency();
    String getCountry();
    String getAddress();
    String getAddress_number();
    String getPostal_code();
    String getRegion();
    String getMunicipality();
    String getLegal_represantation();
    String getLegal_represantation_phone();
    String getLegal_represantation_email();
    Blob getParticipation_certificate();
    Blob getIdentification_document();
    Blob getAvatar();
}
