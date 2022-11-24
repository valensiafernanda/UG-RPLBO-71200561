package com.ug11.kalkulasirupiah;

import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukan teks: ");
        String inp = sc.nextLine();
        System.out.println("Rincian biaya: ");
        String[] spl = inp.split(" ");
        int ttl = 0;
        for (int i = 0; i < spl.length; i++) {
            String ch = spl[i];
            if (ch.contains("Rp")) {
                System.out.print(ch);
                System.out.print(" + ");
//                String a = ch.substring(2,4) + ch.substring(4,8);
            }
        }
        System.out.println();
        System.out.println("Total: " + ttl);
    }
}
