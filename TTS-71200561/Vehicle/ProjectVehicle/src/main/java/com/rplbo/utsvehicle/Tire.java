package com.rplbo.utsvehicle;

public class Tire {
    private  String tireType;
    private int width;
    private int aspectRation;
    private int wheelDiameter;

    public int getAspectRation() {
        return aspectRation;
    }

    public String getTireType(){
        return tireType;
    }

    public int getWheelDiameter() {
        return wheelDiameter;
    }

    public int getWidth() {
        return width;
    }

    public void setAspectRation(int aspectRation) {
        this.aspectRation = aspectRation;
    }

    public void setTireType(String tireType) {
        this.tireType = tireType;
    }

    public void setWheelDiameter(int wheelDiameter) {
        this.wheelDiameter = wheelDiameter;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
