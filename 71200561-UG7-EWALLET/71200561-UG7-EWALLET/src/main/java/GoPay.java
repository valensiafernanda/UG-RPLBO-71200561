import java.util.Scanner;

public class GoPay extends eWallet {
    private int feeTopup = 1000;
    private int feeTransfer = 500;
    private int feeWithdraw = 2500;

    public GoPay(User user){
        super(user);
    }

    public String topup(int jumlah){
        if(jumlah > 10000) {
            System.out.println("Maaf, minimal top up Rp10.000,00");
            return;
        }
        if(jumlah + feeTopup > super.getUser().getUang()){
            jumlah += feeTopup;
            System.out.println("Maaf, uang cash anda tidak mencukupi! ("+ Main.formatRupiah(this.getSaldo()-jumlah)+")");
            return;
        }
        super.topup(jumlah);
        this.pay(feeTopup);
    }


    public void withdraw(int jumlah){
        System.out.println("Withdraw saldo akan terkena potongan fee " + Main.formatRupiah(feeWithdraw));
        if(jumlah + feeWithdraw > super.getSaldo()) {
            jumlah += feeWithdraw;
            System.out.println("Maaf, saldo kamu tidak mencukupi! ("+ Main.formatRupiah(this.getSaldo()-jumlah)+")");
            return;
        }
        System.out.println("Halo, " + this.getUser().getNama() + "! Uang cash sejumlah " + Main.formatRupiah(jumlah) + " telah masuk ke dompetmu!");
        super.withdraw(jumlah);
        this.pay(feeWithdraw);
    }

    public void transfer(eWallet eWallet, int jumlah){
        System.out.println("Masukkan PIN anda: ");
        Scanner input = new Scanner(System.in);
        String password = input.nextLine();
        System.out.println("validasi PIN");
        Main.tunggu(3);
        if(!password.equals(this.getUser().getPIN())){
            System.out.println("Maaf, PIN yang anda masukkan salah");
            return;
        }
        System.out.println("transfer saldo akan terkena potongan fee "+ Main.formatRupiah(feeTransfer));
        System.out.println("transfer sedang diproses");
        Main.tunggu(3);
    }

    public void getInfo() {
        System.out.println("[GoPay e-Wallet]");
        super.getInfo();
    }

