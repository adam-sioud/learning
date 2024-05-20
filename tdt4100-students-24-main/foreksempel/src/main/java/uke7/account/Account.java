package uke7.account;

public interface Account {
    
    public int getBalance(); 
    public int withdraw(int amount); 
    public int deposit(int amount);
}
