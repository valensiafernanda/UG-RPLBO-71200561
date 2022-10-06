package com.ug6.soal1;

import java.util.ArrayList;

public class VendingMachines {
    private String code;
    private int capacity = 0, usedCapacity = 0;
    private double consumerMoney = 0.d;
    private ArrayList<Goods> goods;
    private ArrayList<Double> acceptanceBalance;

    public VendingMachines() {
        this.code = "";
        goods = new ArrayList<>();
        acceptanceBalance = new ArrayList<>();
    }

    public VendingMachines(String code, int capacity) {
        this.code = code;
        this.capacity = capacity;
        goods = new ArrayList<>();
        acceptanceBalance = new ArrayList<>();
    }

    public VendingMachines(String code, int capacity, ArrayList<Goods> goods, ArrayList<Double> acceptanceBalance) {
        this.code = code;
        this.capacity = capacity;
        this.goods = goods;
        this.acceptanceBalance = acceptanceBalance;
    }

    public boolean takeMoney(double money){
        boolean status =  false;
        System.out.println("Uang yang dimasukan sebesar Rp " + money);
        for(double acceptanceBalance : getAcceptanceBalance()){
            if(money == acceptanceBalance){
                setConsumerMoney(money);
                status = true;
                break;
            }
        }
        return status;
    }

    public double withdrawMoney(){
        double money = getConsumerMoney();
        setConsumerMoney(0);
        return money;
    }

    public void proceedOrder(String goodsCode, int orderQuantity){
        int index = 0, tempGoodsCapacity;
        for(Goods goods: getGoods()){
            if(goodsCode.equals(goods.getCode())){
                if(orderQuantity <= goods.getQuantity()){
                    tempGoodsCapacity = getGoods().get(index).getQuantity() - orderQuantity;
                    getGoods().get(index).setQuantity(tempGoodsCapacity);
                    setUsedCapacity(tempGoodsCapacity);
                    giveGoods(getGoods().get(index).getPrice());
                }
                else{
                    System.out.println("Jumlah barang yang anda masukan tidak benar");
                    System.out.println("Transaksi gagal, silahkan ambil uang anda");
                    System.out.println("Mengembalikan uang anda sebesar Rp " + withdrawMoney());
                }
            }
            index++;
        }
    }

    private void giveGoods(double goodsPrice){
        if(getConsumerMoney() > goodsPrice){
            System.out.println("Silahkan ambil pesanan dan kembalian anda sebesar Rp " +
                    (getConsumerMoney()-goodsPrice) +"\nTerima kasih\n\n\n");
        }
        else{
            System.out.println("Silahkan ambil pesanan anda\nTerima kasih\n\n\n");
        }
    }

    public void inputGoods(Goods good){
        getGoods().add(good);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity += capacity;
    }

    public int getUsedCapacity() {
        return usedCapacity;
    }

    public void setUsedCapacity(int usedCapacity) {
        this.usedCapacity = usedCapacity;
    }

    public double getConsumerMoney() {
        return consumerMoney;
    }

    public void setConsumerMoney(double consumerMoney) {
        this.consumerMoney = consumerMoney;
    }

    public ArrayList<Goods> getGoods() {
        return goods;
    }

    public void setGoods(ArrayList<Goods> goods) {
        this.goods = goods;
    }

    public ArrayList<Double> getAcceptanceBalance() {
        return acceptanceBalance;
    }

    public void setAcceptanceBalance(ArrayList<Double> acceptanceBalance) {
        this.acceptanceBalance = acceptanceBalance;
    }
}