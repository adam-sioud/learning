package uke7.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {

    Account account;

    @BeforeEach
    public void setUp() {
        account = new SavingsAccount();
    }

    @Test
    public void testInitialState() {
        assertEquals(0, account.getBalance());
    }

    @Test
    public void testDeposit() {
        account.deposit(1000);
        assertEquals(1000, account.getBalance());
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        account.deposit(1500);
        account.withdraw(500);
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void testWithdrawTooMany() {
        account.deposit(1000);
        account.withdraw(100);
        account.withdraw(100);
        assertThrows(IllegalStateException.class, () -> account.withdraw(100));
    }   


}
