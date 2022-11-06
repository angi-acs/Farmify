package com.smarthack.farmApp.entity;

import javax.persistence.Entity;

public class Color {
    private String color;

    public Color(){

    }
    public Color(String color) {
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
