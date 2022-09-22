import java.sql.Array;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Iterator;

public class Bus {
    private String name;
    private Driver driver;
    private int Capacity;
    private int usedCapacity=0;
    private final ArrayList<Passenger> passenger= new ArrayList<Passenger>();
    private double profit=0;
    private final String[] ROUTE={"Kampus UKDW","Asrama Omah Babadan","Asrama Teologi"};

    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }

    public Driver getDriver(){
        return driver;
    }

    public void setDriver(){
        this.driver = driver;
    }

    public int getCapacity(){
        int capacity = 25;
        return Capacity;
    }

    public ArrayList<Passenger> getPassenger(){
        return passenger;
    }

    public int getUsedCapacity(){
        return usedCapacity;
    }
    public void setUsedCapacity(int usedCapacity){
        this.usedCapacity = usedCapacity;
    }

    public double getFares(){
        double fares = 1500;
        return fares;
    }

    public double getProfit(){
        return profit;
    }

    public void setProfit(double profit){
        this.profit += profit;
    }

    public String[] getROUTE() {
        return ROUTE;
    }


    public boolean checkPassengerBalance(Passenger passenger){
        return passenger.getBalance() >= getFares();
    }

    public void topUpBalance(double balance, Passenger passenger){
        if (balance > 0){
            passenger.setBalance((int) balance);
        }
    }

    public void takePassenger(Passenger passenger){
        this.passenger.add(passenger);
        this.setUsedCapacity(1);
    }

    public void dropPassenger(String tujuan, Passenger penumpang){
        if (tujuan == penumpang.getDestiny()){
            passenger.clear();
        }
    }


}
