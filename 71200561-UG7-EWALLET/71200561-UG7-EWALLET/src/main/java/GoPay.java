import java.util.Scanner;

public class GoPay extends eWallet {
    private int feeTopup = 1000;
    private int feeTransfer = 500;
    private int feeWithdraw = 2500;

    public GoPay(User user) {
        super(user);
    }

    public void topup(int jumlah) {
        if(jumlah < 10000) {
            System.out.println("Maaf, minimal top up Rp10.000,00");
            return;
        }
        if(jumlah + feeTopup > super.getUser().getUang()) {
            jumlah += feeTopup;
            System.out.println("Maaf, uang cash kamu tidak mencukupi! ("+ Main.formatRupiah(this.getSaldo()-jumlah)+")");
            return;
        }
        super.topup(jumlah);
        this.pay(feeTopup);
    }

    public void transfer(eWallet eWallet, int jumlah) {
        System.out.print("Masukkan PIN kamu: ");
        Scanner input = new Scanner(System.in);
        String password = input.nextLine();
        System.out.print("Validasi PIN");
        Main.tunggu(3);
        if(!password.equals(this.getUser().getPIN())) {
            System.out.println("Maaf, PIN yang kamu masukkan salah!");
            return;
        }
        System.out.println("Transfer saldo akan terkena potongan fee " + Main.formatRupiah(feeTransfer));
        System.out.print("Transfer sedang diproses");
        Main.tunggu(3);
        if(jumlah + feeTransfer > super.getSaldo()) {
            jumlah += feeTransfer;
            System.out.println("Maaf, saldo kamu tidak mencukupi! ("+ Main.formatRupiah(this.getSaldo()-jumlah)+")");
            return;
        }
        super.transfer(eWallet, jumlah);
        this.pay(feeTransfer);
    }

    public void withdraw(int jumlah) {
        System.out.println("Withdraw saldo akan terkena potongan fee " + Main.formatRupiah(feeWithdraw));
        if(jumlah + feeWithdraw > super.getSaldo()) {
            jumlah += feeWithdraw;
            System.out.println("Maaf, saldo kamu tidak mencukupi! ("+ Main.formatRupiah(this.getSaldo()-jumlah)+")");
            return;
        }
        super.withdraw(jumlah);
        this.pay(feeWithdraw);
    }

    public void getInfo() {
        System.out.println("[GoPay e-Wallet]");
        super.getInfo();
    }


}
