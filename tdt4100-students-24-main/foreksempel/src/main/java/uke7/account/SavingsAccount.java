package uke7.account;

public class SavingsAccount implements Account{
    
    int balance;
    int withdrawals;
    int maxWithdrawals = 2;

    @Override
    public int getBalance() {
        return balance;
    }
    @Override
    public int withdraw(int amount) {
        if (withdrawals == maxWithdrawals) {
            throw new IllegalStateException("Du forsøker å ta ut flere ganger enn du har lov til.");
        }

        withdrawals += 1;
        if (balance - amount >= 0) {
            balance -= amount;
            System.out.println("SavingsAccount. Gjenværende antall uttak: "+withdrawals);
            return amount;
        }
        return 0;
    }
    @Override
    public int deposit(int amount) {
        balance += amount;
        return balance;
    }

    @Override
    public String toString() {
        return "SavingsAccount: "+balance+ " uttak igjen: "+(maxWithdrawals-withdrawals);
    }
}
