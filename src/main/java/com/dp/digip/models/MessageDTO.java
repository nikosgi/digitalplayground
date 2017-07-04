package com.dp.digip.models;

import java.util.Calendar;
import java.util.Date;

public class MessageDTO {

    public Date date;
    public String content;

    public MessageDTO(String message) {
            this.date = Calendar.getInstance().getTime();
            this.content = message;
    }
}
