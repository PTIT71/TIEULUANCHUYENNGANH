package com.material.components.model;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
     java.util.Date Date;
     String NameDevice;
     String MessageContent;
     String Hour;

    public void setDate(Date date) {
        Date = date;
    }

    public boolean isSection() {
        return section;
    }

    public void setSection(boolean section) {
        this.section = section;
    }

    boolean section = false;

     public Message(String name, boolean section)
     {
         this.section = section;
     }

     public  Message()
     {

     }

    public Date getDate() {
         return  Date;



    }


    public String getNameDevice() {
        return NameDevice;
    }

    public void setNameDevice(String nameDevice) {
        NameDevice = nameDevice;
    }

    public String getMessageContent() {
        return MessageContent;
    }

    public void setMessageContent(String messageContent) {
        MessageContent = messageContent;
    }

    public String getHour() {
        return Hour;
    }

    public void setHour(String hour) {
        Hour = hour;
    }
}
