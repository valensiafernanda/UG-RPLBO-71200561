import java.util.Scanner;

public class Tabungan {
    private static String saldo;

    public static void main(String[] args) {
        TabunganKonvensional K_71200561 = new TabunganKonvensional();
        TabunganBerjangka I_71200561 = new TabunganBerjangka();
        System.out.println("Pilihan: \n" +
                "1.Penyetoran \n" +
                "2.Penarikan \n" +
                "3.Lihat Saldo");

        Scanner inp = new Scanner(System.in);
        System.out.println("Masukkan Pilihan: ");
        int pilihan = inp.nextInt();


        if (pilihan == 1){
            System.out.println("-----Tabungan Konvensional------");
            K_71200561.penyetoran(200000);
            System.out.println("-----Tabungan Berjangka------");
            I_71200561.penyetoran(1000000);
        } if (pilihan == 2){
            System.out.println("-----Tabungan Konvensional------");
            K_71200561.penarikan(50000);
            System.out.println("-----Tabungan Berjangka------");
            System.out.println("Belum jatuh tempo");
        } if (pilihan == 3){
            System.out.println("Saldo K_71200561: " + saldo);

        }
    }
}
