package uke8.mittegetfi;

public class Spiller1 implements SpillInterface{

    @Override
    public void spill(String hva) {
        System.out.println("Jeg spiller på en "+hva);        
    }
    
}
