package uke8.logikk;

import java.text.Format;

/*
    Vi kan definere egne funksjonelle grensesnitt
    Ved å bruke @FunctionalInterface annotasjonen, så vil kompilatoren sjekke at vi
    faktisk har laget et funksjonelt grensesnitt.
    Java gjenkjenner funksjonelle grensesnitt ved at de har kun en abstrakt metode,
    så annotasjonen er ikke nødvendig for at det skal fungere
*/

@FunctionalInterface
interface Operator2<T> {
    T apply(T t1, T t2);
}

@FunctionalInterface
interface Operator3<T> {
    T apply(T t1, T t2, T t3);
}

@FunctionalInterface
interface Operator4<T> {
    T apply(T t1, T t2, T t3, T t4);
}

@FunctionalInterface
interface Operator5<T> {
    T apply(T t1, T t2, T t3, T t4, T t5);
}

@FunctionalInterface
interface Operator6<T> {
    T apply(T t1, T t2, T t3, T t4, T t5, T t6);
}

public class Logiske {
    //todo: Lag metoder 
    
    public static void main(String[] args) {
        // Operator på boolske variable
        Operator2<Boolean> formel1 = (p, q) -> p && (!q || p);
        System.out.println(formel1.apply(true, false));

        // Vi har også bitvise logiske operatorer, ~, &, | 
        // Disse gjør de samme operasjonene parallellt på alle bitposisjonene
        Operator3<Integer> formel2 = (p, q, r) ->  (p | q) & r;
        Integer resultColumn = formel2.apply(0b00001111, 0b00110011, 0b01010101);

        // Det er bare de siste 8 bitsene som er relevante, siden vi har 3 variable her og 2^3 = 8
        // Vi konverterer til streng og setter inn 0'er foran hvis det er nødvendig
        String resultColString = String.format("%32s", Integer.toBinaryString(resultColumn)).replace(' ', '0');
        System.out.println(resultColString.substring(24));

        Boolean r = true & false;
        
        System.out.println(r);
    }
    
}
