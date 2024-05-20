package of0.lf;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Skriv inn et tall: ");
        try {
            int number = scanner.nextInt();
            System.out.println("Ditt tall er " + number);
        } catch (InputMismatchException e) {
            System.out.println("Skriv inn et tall!");
        }

        scanner.close();
    }
}
