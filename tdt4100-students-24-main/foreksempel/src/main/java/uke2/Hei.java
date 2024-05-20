package uke2;

public class Hei {
    
    public static void main(String[] args) {
        System.out.println("hei, verden");

        int x = 16;
        int y = x;  // kopierer verdien i x
        x = 32;
        System.out.println("y er nå " + y);

        Integer a = 16;
        Integer b = a; // kopierer pekeren
        a = 32;
        System.out.println("b er nå " + b);


    }
}
