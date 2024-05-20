package uke7.account;

public class BonusAccount implements Account{

    int balance;
    int MaxCredit = -1000;

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public int withdraw(int amount) {
        if ((balance - amount) >= MaxCredit) {
            balance -= amount;
            return amount;
        }
        throw new IllegalStateException("Du forsøker å ta ut mer enn du har.");
    }

    @Override
    public int deposit(int amount) {
        balance += amount;
        return balance;
    }

    @Override
    public String toString() {
        return "BonusAccount: "+balance+" Credit:"+MaxCredit;
    }

    public int getCredit() {
        return MaxCredit;
    }
}
