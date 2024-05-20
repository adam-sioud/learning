package uke11.abstrakt.interf;

// Slik kunne et interface for bøker sett ut.
// Legg merke til at jeg har definert en egen metode _i_ et interface! 
// Dette er ikke noe som ender opp som pensum i år, men tenkte jeg skulle
// nevne det.
// Hvis du vil lære mer om dette, og hvorfor det er her (siden Java 8),
// se https://stackoverflow.com/questions/36335838/why-is-adding-default-methods-to-interfaces-in-java-8-a-good-design-choice-and-w
// TL;DR: du kan lage metoder i allerede eksisterende interface uten å rote med ting.

public interface IBok {
    public String getTittel();
    public int getAntallSider();

    public default boolean isABigBook() {
        return getAntallSider() > 500;
    }
}
