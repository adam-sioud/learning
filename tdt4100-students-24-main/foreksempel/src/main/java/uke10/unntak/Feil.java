package uke10.unntak;

import java.io.IOException;

class Kall {

    public static String kallMetode() {
            // return 4/0;
        throw new IOException("Lala"); // IllegalArgumentException
    }
}


public class Feil {
    
    private String feilMetode() {
        return Kall.kallMetode();
    }

    public static void main(String[] args) {
        System.out.println(Kall.kallMetode());
    }

}
