package com.dp.digip.models;

public class Greeting {

    private String name;
    private Long eid;
    private String usern;
    public Greeting() {
    }

    public Greeting(String name, Long eid, String usern) {
        this.name = name;
        this.eid = eid;
        this.usern= usern;
    }

    public String getName() {
        return this.name;
    }
    public Long getEid(){
        return this.eid;
    }
    public void setEid(Long eid){
        this.eid = eid;
    }

    public String getUsern(){
        return this.usern;
    }
    public void setUsern(String usern){
        this.usern = usern;
    }

    public void setName(String name) {
        this.name = name;
    }
}