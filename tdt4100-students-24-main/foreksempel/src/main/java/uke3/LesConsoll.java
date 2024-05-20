package uke3;

import java.util.Scanner;

public class LesConsoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tekst = scanner.nextLine();
        scanner.close();
        System.out.println("Tekst: " + tekst);
    }
}

