package uke7.kortomarv;

public class CreditAccount extends Account {
    // arver balance fra Account
    private int creditLine;  //nytt felt, positiv

    // Arver deposit() som den er

    void setCreditLine(int creditLine) {  // ny metode
        if (creditLine < 0) {
            throw new IllegalArgumentException();
        }
        if (balance < -creditLine) {
            throw new IllegalStateException();
        }
        this.creditLine = creditLine;
    }

    @Override
    public void withdraw(int amount) {  // redefinert metode
        if (amount < 0) {
            throw new IllegalArgumentException();
        }

        if (amount >  balance + creditLine) {
            throw new IllegalStateException();
        }
        balance -= amount;
    }

    @Override
    public String toString() {      // redefinert
        return super.toString() + " creditLine is " + creditLine;
    }
    
    public static void main(String[] args) {
        CreditAccount cacc = new CreditAccount();
        cacc.setCreditLine(10000);

        Account acc = cacc;
        acc.withdraw(5000);

        System.out.println(acc);
    }
    
}
