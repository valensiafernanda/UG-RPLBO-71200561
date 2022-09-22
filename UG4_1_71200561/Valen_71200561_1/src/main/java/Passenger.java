public class Passenger {
    private String name;
    private double balance;
    private String email;
    private String destiny;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getDestiny(){
        return destiny;
    }

    public void setDestiny(String destiny){
        this.destiny = destiny;
    }
}
