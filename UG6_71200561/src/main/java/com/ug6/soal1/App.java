package com.ug6.soal1;

import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    private static VendingMachines vm;
    private static final ArrayList<Goods> goods = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static String goodsCode;
    private static int goodsQuantity, jumlahVendingMachine = 0, vmUsedCapacity = 0;
    private static double goodsPrice;
    private static final ArrayList<Double> acceptanceBalance = new ArrayList<>();
    private static final ArrayList<String> goodsOrderCode = new ArrayList<>();

    public static void main( String[] args )
    {
        vendingMachineCreateMenu();
        vmUsedCapacity = 0;
        postConfiguration();
    }

    //method menu untuk membuat object vending machine pertama kali
    private static void vendingMachineCreateMenu() {
        int vmCapacity;
        if(jumlahVendingMachine == 0){
            System.out.println("==============================================================");
            System.out.println("\t\t\tBuat Vending Machine terlebih dahulu");
            System.out.println("==============================================================");
            System.out.print("Kapasitas maximal: ");
            vmCapacity = scanner.nextInt();
            System.out.flush();
            scanner.nextLine();
            inputGoodsMenu(vmCapacity);
        }
    }

    private static void inputGoodsMenu(int vmCapacity) {
        String choice, vmCode = "";
        System.out.print("Apakah anda akan menambahkan barang sekarang?\nya(y) atau tidak(n): ");
        choice = scanner.nextLine();
        System.out.flush();
        if(choice.equalsIgnoreCase("y")){
            inputGoodsInfo(vmCapacity,vmCode);
        }
        else if(choice.equalsIgnoreCase("n")){
            inputAcceptanceBalance();
            jumlahVendingMachine++;
            vmCode = Codes.generateVendingMachineCode(jumlahVendingMachine);
            vm = new VendingMachines(vmCode,vmCapacity, goods, acceptanceBalance);
            vm.setUsedCapacity(0);
            System.out.println("Selamat telah menyelesaikan konfigurasi utama");
        }
        else{
            System.out.println("Input yang anda masukan salah");
            inputGoodsMenu(vmCapacity);
        }
    }

    private static void inputGoodsInfo(int vmMaxCapacity, String vmCode) {
        System.out.print("Nama barang: ");
        String goodsName = scanner.nextLine();
        inputGoodsCode(goodsName);
        System.out.println("Apakah anda ingin memasukan nominal harga dan jumlah barang?");
        System.out.print("ya(y) atau tidak(n): ");
        String choice = scanner.nextLine();
        System.out.flush();
        Goods good;
        if(choice.equalsIgnoreCase("y")){
            inputGoodsPriceAndCapacity(vmMaxCapacity);
            good = new Goods(getGoodsCode(), goodsName,getGoodsQuantity(),getGoodsPrice());
            goods.add(good);
            addMoreGoods(good, vmMaxCapacity,vmCode);
        }
        else if(choice.equalsIgnoreCase("n")){
            good = new Goods(getGoodsCode(), goodsName);
            goods.add(good);
            addMoreGoods(good, vmMaxCapacity,vmCode);
        }
        else{
            System.out.println("Input yang anda masukan salah");
            inputGoodsMenu(vmMaxCapacity);
        }
    }

    private static void addMoreGoods(Goods good, int vmCapacity, String vmCode){
        if(vmUsedCapacity < 30){
            System.out.println("Apakah anda ingin menambahkan lagi?");
            System.out.print("Ya(y) atau tidak(n): ");
            String choice = scanner.nextLine();
            System.out.flush();
            if(choice.equalsIgnoreCase("y")){
                vmUsedCapacity += good.getQuantity();
                System.out.println("\n");
                inputGoodsInfo(vmCapacity,vmCode);
            }
            else if(choice.equalsIgnoreCase("n")){
                inputAcceptanceBalance();
                jumlahVendingMachine++;
                vmUsedCapacity += good.getQuantity();
                vmCode = Codes.generateVendingMachineCode(jumlahVendingMachine);
                vm = new VendingMachines(vmCode,vmCapacity,goods,acceptanceBalance);
                vm.setUsedCapacity(vmUsedCapacity);
                System.out.println("Selamat telah menyelesaikan konfigurasi utama");
            }
            else{
                System.out.println("Input yang anda masukan salah");
                inputGoodsMenu(vmCapacity);
            }
        }
        else if(vmUsedCapacity == 30){
            System.out.println("Maaf tidak dapat menambahkan barang lagi");
            System.out.println("Selamat telah menyelesaikan konfigurasi utama");
        }
    }

    private static void inputGoodsCode(String goodsName){
        System.out.println("Type barang: ");
        int order = 1;
        for(String types : Codes.TYPES){
            if(types.equals(Codes.TYPES[0])){
                System.out.println(order + ". " + "Minuman");
            }
            else if(types.equals(Codes.TYPES[1])){
                System.out.println(order + ". " + "Makanan");
            }
            else if(types.equals(Codes.TYPES[2])){
                System.out.println(order + ". " + "Produk Digital");
            }
            order++;
        }
        System.out.print("Pilihan (1/2/3): ");
        int choice = scanner.nextInt();
        System.out.flush();
        scanner.nextLine();
        switch(choice){
            case 1 -> setGoodsCode(Codes.generateGoodCode(Codes.TYPES[0],goodsName));
            case 2 -> setGoodsCode(Codes.generateGoodCode(Codes.TYPES[1],goodsName));
            case 3 -> setGoodsCode(Codes.generateGoodCode(Codes.TYPES[2],goodsName));
            default -> {
                System.out.println("Input yang anda masukan salah");
                inputGoodsCode(goodsName);
            }
        }
    }
    //===========================================================================================

    //Method menu setelah object berhasil dibuat
    private static void postConfiguration(){
        String choice;
        System.out.println("\n\n\n");
        System.out.println("==============================================================");
        System.out.println("\t\t\tPost Configuration");
        System.out.println("==============================================================");
        System.out.println("Kode Vending Machine: " + vm.getCode());
        System.out.println("Total kapasitas barang yang dapat disimpan: " + vm.getCapacity());
        System.out.println("Kapasitas yang telah dipakai: " + vm.getUsedCapacity());
        vmUsedCapacity = vm.getUsedCapacity();
        System.out.println("\n\nOption");
        if(vm.getUsedCapacity() == 0){
            System.out.println("1. Tambah barang");
            System.out.println("2. update barang");
            System.out.print("Pilihanmu: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> configureinputGoodsMenu();
                case "2" -> configureUpdateGoodsMenu();
                case "3" -> {
                    System.out.println("Tambahkan barang terlebih dahulu");
                    postConfiguration();
                }
            }
        }
        else{
            System.out.println("1. Tambah barang");
            System.out.println("2. update barang");
            System.out.println("3. Selesai konfigurasi");
            System.out.print("Pilihanmu: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.println("\n\n");
                    System.out.println("==============================================================");
                    System.out.println("\t\t\tTambahkan barang baru");
                    System.out.println("==============================================================");
                    configureinputGoodsMenu();
                }
                case "2" -> configureUpdateGoodsMenu();
                case "3" -> vendingMachineMenu();
            }
        }
    }

    private static void configureinputGoodsMenu(){
        String goodsName, choice;
        Goods good;
        if(vm.getUsedCapacity() < vm.getCapacity()){
            System.out.print("Nama barang: ");
            goodsName = scanner.nextLine();
            inputGoodsCode(goodsName);
            System.out.println("Apakah anda ingin memasukan nominal harga dan jumlah barang?");
            System.out.print("ya(y) atau tidak(n): ");
            choice = scanner.nextLine();
            System.out.flush();
            if(choice.equalsIgnoreCase("y")){
                inputGoodsPriceAndCapacity(vm.getCapacity());
                good = new Goods(getGoodsCode(),goodsName,getGoodsQuantity(),getGoodsPrice());
                postConfigurationAddMoreGoods(good);
            }
            else if(choice.equalsIgnoreCase("n")){
                good = new Goods(getGoodsCode(),goodsName);
                postConfigurationAddMoreGoods(good);
                postConfiguration();
            }
            else{
                System.out.println("Input yang anda masukan salah");
                configureinputGoodsMenu();
            }
        }
        else{
            System.out.println("Kapasitas telah penuh. Tidak dapat menambahkan barang baru");
            postConfiguration();
        }
    }

    private static void postConfigurationAddMoreGoods(Goods good) {
        System.out.println("Apakah anda ingin menambahkan lagi?");
        System.out.print("Ya(y) atau tidak(n): ");
        String choice = scanner.nextLine();
        System.out.flush();
        if(choice.equalsIgnoreCase("y")){
            vm.getGoods().add(good);
            vm.setUsedCapacity(good.getQuantity());
            configureinputGoodsMenu();
        }
        else if(choice.equalsIgnoreCase("n")){
            vm.getGoods().add(good);
            vm.setUsedCapacity(good.getQuantity());
            System.out.println("Sukses menambahkan barang");
            postConfiguration();
        }
        else{
            System.out.println("Input yang anda masukan salah");
            configureinputGoodsMenu();
        }
    }

    private static void configureUpdateGoodsMenu() {
        int updateGoodsQuantity;
        String choice, updateGoodsName;
        double updateGoodsPrice;
        System.out.println("\n\n==============================================================");
        System.out.println("\t\t\tUpdate Goods Info");
        System.out.println("==============================================================");
        if(vm.getGoods().size() == 0){
            System.out.println("Tidak ada barang yang disimpan," +
                    " mohon tambahkan barang terlebih dahulu\n\n\n");
            postConfiguration();
        }
        else{
            int index = 1;
            System.out.println("\n");
            System.out.println("Menampilkan barang yang ada");
            for(Goods goods : vm.getGoods()){
                goodsOrderCode.add(goods.getCode());
                System.out.println(index + ". " + goods.getName());
                System.out.println("   Harga: Rp " + goods.getPrice());
                System.out.println("   Jumlah barang: " + goods.getQuantity());
                index++;
            }
            System.out.println(index + ". Kembali");
            System.out.print("Pilih barang mana yang akan di update: ");
            choice = scanner.nextLine();
            if(choice.isEmpty()){
                System.out.println("Mohon masukan pilihan anda\n\n\n");
                configureUpdateGoodsMenu();
            }
            else if(choice.equals(""+index)){
                postConfiguration();
            }
            else{
                System.out.print("Nama barang: ");
                updateGoodsName = scanner.nextLine();
                System.out.print("Harga barang: ");
                updateGoodsPrice = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Jumlah barang: ");
                updateGoodsQuantity = scanner.nextInt();
                scanner.nextLine();
                if(updateGoodsQuantity + vm.getUsedCapacity() > vm.getCapacity()){
                    System.out.println("Maaf jumlah yang dimasukan tidak dapat melebihi kapasitas");
                    System.out.println("\n\n");
                    configureUpdateGoodsMenu();
                }
                else{
                    vmUsedCapacity = (vmUsedCapacity - vm.getGoods().get(index-2).getQuantity()) + updateGoodsQuantity;
                    vm.getGoods().get(index-2).setName(updateGoodsName);
                    vm.getGoods().get(index-2).setPrice(updateGoodsPrice);
                    vm.getGoods().get(index-2).setQuantity(updateGoodsQuantity);
                    vm.setUsedCapacity(vmUsedCapacity);
                    System.out.println("Berhasi merubah data\n\n");
                    postConfiguration();
                }
            }
        }
    }
    //===========================================================================================

    //Method menu untuk menampilkan proses penjualan ke konsumen
    private static void vendingMachineMenu() {
        int order = 1, orderQuantity, choice;
        double money;
        System.out.flush();
        System.out.println("\n\n\n");
        System.out.println("==============================================================");
        System.out.println("\t\t\tVending Machine");
        System.out.println("==============================================================");
        System.out.print("Nominal uang yang dapat diberikan: ");
        for(double goods : vm.getAcceptanceBalance()){
            System.out.print("Rp " + goods + ", ");
        }
        System.out.println("\n\n");
        System.out.println("Silahkan pilih apa yang ingin anda beli: ");
        for(Goods goods : vm.getGoods()){
            goodsOrderCode.add(goods.getCode());
            System.out.println(order + ". " + goods.getName());
            System.out.println("   Harga: " + goods.getPrice());
            System.out.println("   Jumlah barang: " + goods.getQuantity());
            order++;
        }
        System.out.print("Pilihanmu: ");
        choice = scanner.nextInt();
        scanner.nextLine();
        if(choice < 0 || choice > order){
            System.out.println("Maaf input yang anda masukan salah");
            vendingMachineMenu();
        }
        else{
            System.out.print("Masukan uang anda: ");
            money = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Masukan jumlah barang yang ingin dibeli: ");
            orderQuantity = scanner.nextInt();
            scanner.nextLine();
            proceedOrder(choice,money,orderQuantity);
        }
    }

    private static void proceedOrder(int choice, double money, int orderQuantity) {
        int order = 0;
        if(vm.takeMoney(money)){
            double totalUangKonsumen = money * orderQuantity;
            System.out.println("Uang sebesar Rp " + money + " diterima");
            for(String code : goodsOrderCode){
                if((choice-1) == order){
                    if(totalUangKonsumen >= vm.getGoods().get(order).getPrice()){
                        vm.proceedOrder(code,orderQuantity);
                        vendingMachineMenu();
                    }
                    else if(totalUangKonsumen < vm.getGoods().get(order).getPrice()){
                        System.out.println("Maaf uang kamu kurang");
                        vm.withdrawMoney();
                        System.out.println("\n\n");
                        vendingMachineMenu();
                    }
                }
                order++;
            }
        }
        else{
            System.out.println("Maaf, nominal uang yang anda masukan tidak dapat kami terima");
            System.out.println("Mengembalikan uang anda sebesar Rp " + money);
            vendingMachineMenu();
        }
    }
    //===========================================================================================

    //Method extensi yang dapat digunakan
    private static void inputGoodsPriceAndCapacity(int vmMaxCapacity){
        String tempPrice =  "", tempQuantity = "";
        System.out.print("Harga barang: ");
        tempPrice += scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Kapasitas barang yang ada/dimiliki: ");
        tempQuantity += scanner.nextInt();
        scanner.nextLine();
        System.out.flush();
        if(tempPrice.isEmpty() && tempQuantity.isEmpty()){
            System.out.println("Input yang kamu masukan tidak sesuai");
            inputGoodsPriceAndCapacity(vmMaxCapacity);
        }
        else{
            //Cek apakah kapasitas yang digunakan melebihi kapasitas maximal
            if(Integer.parseInt(tempQuantity) + vmUsedCapacity <= vmMaxCapacity){
                setGoodsPrice(Double.parseDouble(tempPrice));
                setGoodsQuantity(Integer.parseInt(tempQuantity));
            }
            else{
                System.out.println("Jumlah barang telah melampaui kapasitas maximal");
                System.out.println("Ulangi proses penambahan harga");
                System.out.println("\n");
                inputGoodsPriceAndCapacity(vmMaxCapacity);
            }
        }
    }

    private static void inputAcceptanceBalance(){
        System.out.println("\n");
        System.out.println("Nominal uang yang diperbolehkan: ");
        System.out.println("1. Rp 5.000, Rp 10.000, Rp 20.000");
        System.out.println("2. Rp 10.000, Rp 20.000, Rp 50.000");
        System.out.println("3. Rp 5.000 Rp 10.000, Rp 20.000, Rp 50.000");
        System.out.println("4. Rp 10.000, Rp 20.000, Rp 50.000, Rp 100.000");
        System.out.print("Pilihan anda: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch(choice){
            case 1 -> {
                acceptanceBalance.add(5000.d);
                acceptanceBalance.add(10000.d);
                acceptanceBalance.add(20000.d);
            }
            case 2 -> {
                acceptanceBalance.add(10000.d);
                acceptanceBalance.add(20000.d);
                acceptanceBalance.add(50000.d);
            }
            case 3 -> {
                acceptanceBalance.add(5000.d);
                acceptanceBalance.add(10000.d);
                acceptanceBalance.add(20000.d);
                acceptanceBalance.add(50000.d);
            }
            case 4 -> {
                acceptanceBalance.add(10000.d);
                acceptanceBalance.add(20000.d);
                acceptanceBalance.add(50000.d);
                acceptanceBalance.add(100000.d);
            }
            default -> {
                System.out.println("Input yang anda masukan salah\n\n");
                inputAcceptanceBalance();
            }
        }
    }

    public static String getGoodsCode() {
        return goodsCode;
    }

    public static void setGoodsCode(String goodsCode) {
        App.goodsCode = goodsCode;
    }

    public static int getGoodsQuantity() {
        return goodsQuantity;
    }

    public static void setGoodsQuantity(int goodsQuantity) {
        App.goodsQuantity = goodsQuantity;
    }

    public static double getGoodsPrice() {
        return goodsPrice;
    }

    public static void setGoodsPrice(double goodsPrice) {
        App.goodsPrice = goodsPrice;
    }
    //===========================================================================================
}
