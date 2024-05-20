package uke2;

public class BrukTellNed {
    
    public static void main(String[] args) {

        TellNed teller = new TellNed(5);
        while (! teller.ferdig()) {
            teller.tellned();
            System.out.println(teller.getTall()); //Kan ikke skrive teller.tall her
        }
    }
}
