package uke8.mittegetfi;

import java.util.ArrayList;
import java.util.List;

public class VisBruk {


    public static void main(String[] args) {
        List<SpillInterface> spillere = new ArrayList<>();
        spillere.add(new Spiller1());
        spillere.add(new Spiller2());
        spillere.add(x -> System.out.println("Nekter. Henger "+x+" tilbake på veggen"));

        spillere.forEach(x -> x.spill("gitar"));

    }
}
