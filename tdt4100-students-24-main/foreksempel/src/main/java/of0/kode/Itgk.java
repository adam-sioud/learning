package of0.kode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Itgk {

    // Skriv koden her

    public static void main(String[] args) {
        Itgk itgk = new Itgk();

        System.out.println(itgk.treLike("Bord", "BoRReMaskin"));
        System.out.println(itgk.treLike("Java", "Python"));

        List<Integer> list = new ArrayList<>(List.of(2, -3, 5, -1, 7, 6, 4));

        System.out.println(itgk.sumPosOdd(list));

        String string = "Hakuna Matata";
        String karakter = "a";

        System.out.println(itgk.splitString(string, karakter));
    }
}
