package uke7.account;

public class RegularAccount implements Account{
    
    private int balance;


    public int getBalance() {
        return this.balance;
    }

    public int deposit(int amount) {
        balance += amount;
        return balance;
    }

    public int withdraw(int amount) {

        if (balance - amount >= 0) {
            balance -= amount;
            System.out.println("RegularAccount: klarert for uttak.");
            return amount;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "RegularAccount: "+balance;
    }

    public static void main(String[] args) {
        RegularAccount ra = new RegularAccount();
        System.out.println(ra.getBalance());
        System.out.println(ra.deposit(1000));
        System.out.println(ra.getBalance());
        System.out.println(ra);
    }
}
