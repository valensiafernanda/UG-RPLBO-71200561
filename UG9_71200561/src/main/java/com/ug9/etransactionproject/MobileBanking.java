package com.ug9.etransactionproject;

public class MobileBanking {
    private boolean checkFee;
    private long feeAntarBank = 6000;
    private String noRekening;

    public MobileBanking(String nama, long saldo, String  noRekening){
        super(nama, saldo);
        this.noRekening = noRekening;
    }

    public String getNoRekening() {
        return noRekening;
    }

    public void setCheckFee(boolean checkFee) {
        this.checkFee = checkFee;
    }

    public void transfer(DigitalPayment dp, long nominal){

    }

    public boolean isCheckFee() {
        return checkFee;
    }
}
