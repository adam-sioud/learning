package uke9.iostreams;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

public class BrukFileReader {
    public static void main(String[] args) {

        
        /* FileReader arver fra InputStreamReader som arver fra Reader:
            - public class InputStreamReader extends Reader {}
            - public class FileReader extends InputStreamReader {}
       
        FileReader-konstruktøren deklarerer en såkalt "checked exception":
        Vi får kompileringsfeil hvis vi ikke håndterer den, eller deklarerer 
        en checked exception.
        Vi bruker en try-with-resources, som også automatisk lukker strømmen.
        
        Oppsettet vår er slik at "current working directory" er prosjektmappen,
        Her bruker vi relativ sti til filen, fra TDT4100-STUDENTS-24
        */

        try (Reader reader = new FileReader("foreksempel/src/main/java/uke9/iostreams/test.txt")) {
            // Lese ett og ett tegn:
            int c;
            while ((c = reader.read()) != -1) {
                System.out.println(Character.toString((char) c) + " tallverdi = " + c);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // La oss lese filen på nytt, og nå lese en større bolk i en go.

        try (Reader reader = new FileReader("foreksempel/src/main/java/uke9/iostreams/test.txt")) {
            // Vi kan lese inn flere tegn, som vi legger i en.
            char[] buffer = new char[100];  // Leser 100 tegn eller til slutten av filen.
            int charCount = reader.read(buffer);
            System.out.println("Antall tegn lest: " + charCount);
            System.out.print(buffer);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
