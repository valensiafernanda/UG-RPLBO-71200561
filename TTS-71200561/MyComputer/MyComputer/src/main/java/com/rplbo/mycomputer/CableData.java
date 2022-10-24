package com.rplbo.mycomputer;

public class CableData {
    private Computer computer1;
    private Computer computer2;

    public CableData(){

    }

    public boolean attach(Computer computer){
        return false;
    }

    public boolean detach(Computer computer){
        return false;
    }

    public Computer getComputer1() {
        return computer1;
    }

    public Computer getComputer2() {
        return computer2;
    }

    public boolean sendData(Computer computer, String data){
        return false;
    }
}
