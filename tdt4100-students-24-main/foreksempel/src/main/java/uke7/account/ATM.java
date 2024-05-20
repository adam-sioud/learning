package uke7.account;

public class ATM {
    
    public void withdraw(Account account, int amount) {

        try {
            int money = account.withdraw(amount);
            if (money > 0) {
                System.out.println("ATM: Du fikk tatt ut "+money);
            }                
        } catch (Exception e) {
            System.out.println("Unntak i ATM.withdrawal: "+e.getLocalizedMessage());
        }
    }

    public void deposit(Account account, int amount) {
        account.deposit(amount);
    }

    public void getBalance(Account account) {
        if (account instanceof BonusAccount) {
            BonusAccount ba = (BonusAccount) account;
            System.out.println("(ATM BA) Kredittgrense: "+ba.getCredit());
        }
        System.out.println("ATM getBalance: "+account.getBalance());
    }
}
