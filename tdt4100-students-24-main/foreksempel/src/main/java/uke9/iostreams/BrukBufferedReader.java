package uke9.iostreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BrukBufferedReader {
    
    public static void main(String[] args) {
        
        //Her ser dere pathen skrevet på Windows-vis. Backslash må "escapes", dvs. skrives \\
        String filePath = "C:\\4100\\tdt4100-students-24\\foreksempel\\src\\main\\java\\uke9\\iostreams\\BrukBufferedReader.java";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine())!= null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
