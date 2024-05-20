package uke9.iostreams;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StreamFromResources {
    public static void main(String[] args) {
    
        try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(StreamFromResources.class.getResourceAsStream("test.txt")))) {
            
                reader.lines().forEach(System.out::println);    
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
