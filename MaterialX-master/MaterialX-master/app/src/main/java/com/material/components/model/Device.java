package com.material.components.model;

import java.io.Serializable;

public class Device implements Serializable {

    private String ID;
    private String PartCode;
    private String Name;
    private  String SubDescription;

    public String getSubDescription() {
        return SubDescription;
    }

    public void setSubDescription(String subDescription) {
        SubDescription = subDescription;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    private String StartDate;
    private int Status;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPartCode() {
        return PartCode;
    }

    public void setPartCode(String partCode) {
        PartCode = partCode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }


}
