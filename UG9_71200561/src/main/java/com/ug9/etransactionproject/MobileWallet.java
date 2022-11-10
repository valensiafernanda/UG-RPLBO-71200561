package com.ug9.etransactionproject;

import java.util.PriorityQueue;

public class MobileWallet {
    private String noHP;
    private long feeTranferBank;

    public MobileWallet(String nama, long saldo,String noHP){
        super(nama, saldo);
        this.noHP = noHP;
    }

    public void transfer(DigitalPayment dp, long nominal){

    }
}
