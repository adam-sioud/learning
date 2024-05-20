package of0.lf;

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

        /*
         * String string = "Hakuna Matata";
         * String karakter = "a";
         * 
         * System.out.println(itgk.splitString(string, karakter));
         */
    }

    int sumPosOdd(List<Integer> numbers) {
        int sum = 0;

        for (Integer num : numbers) {
            if (num % 2 == 0 && num > 0) {
                sum += num;
            }
        }

        return sum;
    }

    boolean treLike(String str1, String str2) {
        String firstStr1 = str1.substring(0, 3);
        String firstStr2 = str2.substring(0, 3);

        return firstStr1.equalsIgnoreCase(firstStr2);
    }
}
