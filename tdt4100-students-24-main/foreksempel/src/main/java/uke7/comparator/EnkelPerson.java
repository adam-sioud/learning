package uke7.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnkelPerson {
    String navn;

    public String getNavn() {
        return navn;
    }

    public EnkelPerson(String navn) {
        this.navn = navn;
    }

    @Override
    public String toString() {
        return navn;
    } 

    public static void main(String[] args) {
        List<EnkelPerson> simpletons = new ArrayList<>();
        simpletons.add(new EnkelPerson("Per"));
        simpletons.add(new EnkelPerson("Pål"));
        simpletons.add(new EnkelPerson("Espen"));

    // Følgende går ikke. Java gjetter ikke på at vi skal sortere
    // på String, selv om det er eneste felt i klassen
    // 
    // Collections.sort(simpletons);
    // 
        
    // Vi må angi sammenligningsmetode:
    Collections.sort(simpletons, new EnkelPersonSortering());
    
    // Likt det over, men kalles som metode på objektet:
    simpletons.sort(new EnkelPersonSortering());

    System.out.println(simpletons);
    }
}
