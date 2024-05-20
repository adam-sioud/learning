package uke9.iostreams;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class BrukPrintStream {
    public static void main(String[] args) {

        String tekst = "Skriv dette til fil. \nNy linje \u0880";

        try (FileOutputStream fos = new FileOutputStream("c:/temp/utfil.txt")) {
            PrintStream output = new PrintStream(fos);
            output.println(tekst);
            // output.close(); // Ikke nødvendig siden den lukker automatisk

        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintStream out = System.out;
    }
}
