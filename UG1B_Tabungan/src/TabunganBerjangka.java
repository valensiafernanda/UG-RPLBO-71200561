public class TabunganBerjangka {
    private String pemilik;
    private double saldo;

    public void getSaldo(){

    }
    public void penarikan(double jumlah){
        saldo = saldo - jumlah;
        System.out.println("penarikan Rp." + saldo);
    }

    public void penyetoran(double jumlah){
        saldo = saldo + jumlah;
        System.out.println("penyetoran Rp." + saldo);
    }
}
