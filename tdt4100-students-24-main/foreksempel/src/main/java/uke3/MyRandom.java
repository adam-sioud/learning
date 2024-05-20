package uke3;

import java.util.Random;

public class MyRandom {
    
    public static void main(String[] args) {
        // Å bruke samme "seed" i konstruktøren til Random, gir samme tallsekvens
        Random rnd123 = new Random(123); 
        System.out.println(rnd123.nextInt(100,110));
        System.out.println(rnd123.nextInt(100,110));

        // Hvis vi ikke angir "seed", så lager konstruktøren en ny for hver kjøring
        Random rnd = new Random();
        System.out.println(rnd.nextInt(100,110));
        System.out.println(rnd.nextInt(100,110));
    }
}
