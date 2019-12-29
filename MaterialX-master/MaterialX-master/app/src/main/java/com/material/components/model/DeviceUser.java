package com.material.components.model;

import java.io.Serializable;
import java.util.Date;

public class DeviceUser implements Serializable {

    public String getIDUser() {
        return IDUser;
    }

    public void setIDUser(String IDUser) {
        this.IDUser = IDUser;
    }

    public String getIDDevice() {
        return IDDevice;
    }

    public void setIDDevice(String IDDevice) {
        this.IDDevice = IDDevice;
    }

    public Date getDateConnect() {
        return DateConnect;
    }

    public void setDateConnect(Date dateConnect) {
        DateConnect = dateConnect;
    }

    private String IDUser;
    private String IDDevice;
    private Date DateConnect;
}
