package com.ug6.soal1;

public class Codes {
    private final static String GOODSCODE = "GD";
    private final static String VENDINGMACHINESCODE = "VD";
    public final static String[] TYPES = {"DK","FD", "DG"};

    public static String generateGoodCode(String type, String name){
        return Codes.GOODSCODE + type + name.charAt(0) + name.charAt(name.length()-1);
    }

    public static String generateVendingMachineCode(int order){
        if(order < 10){
            return Codes.VENDINGMACHINESCODE + "0" + order;
        }
        else{
            return Codes.VENDINGMACHINESCODE + order;
        }
    }
}
