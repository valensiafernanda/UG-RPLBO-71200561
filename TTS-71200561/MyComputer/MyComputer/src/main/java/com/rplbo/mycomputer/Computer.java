package com.rplbo.mycomputer;

public class Computer {
    private int ID;
    private int GlobalID;
    private CableData cableData;
    private Storage storage;

    Computer(Storage storage){

    }

    public Storage getStorage(){
        return storage;
    }

    public boolean detachCableData(){

        return false;
    }

    public void retrieveData(String data){

    }

    public boolean sendData(String data){

        return false;
    }

    public int getID() {
        return ID;
    }

    public boolean attachCableData(CableData kabel){
        return false;
    }
}
