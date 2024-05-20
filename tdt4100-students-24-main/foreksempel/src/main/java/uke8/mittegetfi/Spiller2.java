package uke8.mittegetfi;

public class Spiller2 implements SpillInterface{

    @Override
    public void spill(String hva) {
        System.out.println("Jeg vil absolutt ikke spille på en "+hva+", så da blir det CS:GO i stedet");        
    }
}
