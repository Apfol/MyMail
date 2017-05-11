package com.fragments.apfol.andresramos.mymail.models;

import android.graphics.Color;

/**
 * Created by Andres Ramos on 5/7/2017.
 */

public class Mail {
    private String subject, message, sender;
    private int color;

    public Mail(String subject, String message, String sender, int color) {
        this.subject = subject;
        this.message = message;
        this.sender = sender;
        this.color = color;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public String getSender() {
        return sender;
    }

    public int getColor() {
        return color;
    }
}


