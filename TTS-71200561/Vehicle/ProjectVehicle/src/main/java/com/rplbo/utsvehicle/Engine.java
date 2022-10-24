package com.rplbo.utsvehicle;

public class Engine {
    private String fuelType;
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public String getFuelType(){
        return fuelType;
    }

    public void setFuelType(){
        this.fuelType = fuelType;
    }

    public void setCapacity(){
        this.capacity = capacity;
    }
}
