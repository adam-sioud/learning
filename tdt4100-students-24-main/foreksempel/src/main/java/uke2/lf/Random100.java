package uke2.lf;

import java.util.Random;

public class Random100 {
    
    Random random;

    public Random100() {
        this.random = new Random();
    }

    public int getRandom100() {
        return random.nextInt(100);
    }

    public static void main(String[] args) {
        Random100 r = new Random100();
        System.out.println(r.getRandom100());
        System.out.println(r.getRandom100());
    }
}
