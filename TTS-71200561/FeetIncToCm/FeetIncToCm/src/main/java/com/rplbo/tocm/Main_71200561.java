package com.rplbo.tocm;

public class Main_71200561 {

    int inc = (int) 2.54;
    int foot = 12;

    public double FeetIncToCm(int inci){
        if (inci <= 0 ){
            return -1;
        }else{
            int feeet = inci/12;
            int inciSisa = inci - feeet;
            System.out.println(inci + " inc = " + feeet + " feet " + inciSisa + " inc");
            FeetIncToCm(feeet, inciSisa);
            }
        return 0;
    }


    public double FeetIncToCm(double feet,double inch){
        if(inch <= 0 || feet <= 0){
            return -1;
        }else if (inch >12 || feet > 12){
            return -1;
        }else{
            int feetKeInch = (int) (feet*foot);
            int inchKeCM = feetKeInch*inc;
            System.out.println("Nilai dalam cetimeter: "+inchKeCM);
        }
        return feet;
    }

    public static void main(String[] args) {
        FeetIncToCm(1,3);
        FeetIncToCm(15);
    }
}