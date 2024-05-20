package uke9.iostreams;

import java.io.IOException;
import java.io.InputStreamReader;

public class BrukInputStreamReader {
    public static void main(String[] args) {

        // Henter kun en BYTE fra terminal
        try {
            int c = System.in.read();
            System.out.print((char) c);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        // Vi pakkser System.in i en InputStreamReader. Denne legger til mekanismer
        // for å lese tegn fra byte-strømmen.
        try (InputStreamReader isr = new InputStreamReader(System.in)) {
            int c;
            while ((c = isr.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
