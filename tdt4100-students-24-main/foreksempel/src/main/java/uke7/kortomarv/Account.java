package uke7.kortomarv;

public class Account {
    protected int balance;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            throw new IllegalStateException();
        }
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public String toString() {
        return "Balance is " + balance;
    }

}
