package com.dp.digip.models;

import java.util.Calendar;
import java.util.Date;

public class MessageDTO {

    public Date date;
    public String content;
    public String username;

    public MessageDTO(String message, String username) {
            this.date = Calendar.getInstance().getTime();
            this.content = message;
            this.username = username;
    }
}
