package com.dp.digip.models;

public class Greeting {

    private String name;
    private Long eid;
    private int stars;
    public Greeting() {
    }

    public Greeting(String name, Long eid, int stars) {
        this.name = name;
        this.eid = eid;
        this.stars= stars;
    }

    public String getName() {
        return this.name;
    }
    public Long getEventId(){
        return this.eid;
    }
    public void setName(String name) {
        this.name = name;
    }
}