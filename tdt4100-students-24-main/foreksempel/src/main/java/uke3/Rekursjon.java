package uke3;

public class Rekursjon {
    /* Funksjonen f kaller seg selv rekursivt. 
     * Hvert kall oppretter en ny kopi av x (nytt ark i ark-modellen)
     * For x mindre enn 5, så fungerer det helt likt som å kalle f0 nedenfor,
     * som så kaller f1, som kaller f2 osv.
     */
    static void f(int x) {  
        System.out.println("f, x = " + x);
        if (x > 0) {
            f(x-1);   // Rekursivt kall
        }
    }
    
    /* Funksjonene f0 til f5 kalles i sekvens. Å kalle f0 med x mindre enn 5,
     * gir samme resultat som å kalle f over, bortsett fra print-setningene.
     */
    static void f0(int x) {
        System.out.println("f0, x = " + x);
        if (x > 0) {
            f1(x-1);
        }
    }

    static void f1(int x) {
        System.out.println("f1, x = " + x);
        if (x > 0) {
            f2(x-1);
        }
    }

    static void f2(int x) {
        System.out.println("f2, x = " + x);
        if (x > 0) {
            f3(x-1);
        }
    }

    static void f3(int x) {
        System.out.println("f3, x = " + x);
        if (x > 0) {
            f4(x-1);
        }
    }

    static void f4(int x) {
        System.out.println("f4, x = " + x);
        if (x > 0) {
            System.out.println("Her stopper det");
        }

    }


    static public void main(String[] args) {
        System.out.println("Kall f0(4) går helt til 0:");
        f0(4);
        System.out.println("Kallet f0(5) går ikke til 0:");
        f0(5);
        System.out.println("Kall f(5) går til null:");
        f(5);
    }
}
