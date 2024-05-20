package uke8.streng;

import java.util.Iterator;

// La oss kapsle inn en String, og lage vår egen Iterable for den!  
public class Streng implements Iterable<Character>{
    
    String streng;

    public Streng(String streng) {
        this.streng = streng;
    }

    @Override
    public Iterator<Character> iterator() {
        return new StrengIterator(this.streng);
    }

    public static void main(String[] args) {
        Streng s = new Streng("Hei på oss");
        for (Character character : s) {
            System.out.println("Tegn: "+character);
        }
    }

}
