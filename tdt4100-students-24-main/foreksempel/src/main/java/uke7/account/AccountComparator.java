package uke7.account;

import java.util.Comparator;

public class AccountComparator implements Comparator<Account> {

    @Override
    public int compare(Account o1, Account o2) {
        return o1.getBalance() - o2.getBalance();
    }

}
