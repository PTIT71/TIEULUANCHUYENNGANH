package com.material.components.model;

public class SensorDevice {
    String name;
    String id;
    String currentvalue;
    Integer type;

    public String getMaxvalue() {
        return Maxvalue;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setMaxvalue(String maxvalue) {
        Maxvalue = maxvalue;
    }

    public String getMinvalue() {
        return Minvalue;
    }

    public void setMinvalue(String minvalue) {
        Minvalue = minvalue;
    }

    String Maxvalue;
    String Minvalue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrentvalue() {
        return currentvalue;
    }

    public void setCurrentvalue(String currentvalue) {
        this.currentvalue = currentvalue;
    }

}
