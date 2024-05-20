package uke9.iostreams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class IoLambda {
    public static void main(String[] args) {
        
        // Create file
        String currentDirectory = System.getProperty("user.dir");
        System.out.println("Current working directory: " + currentDirectory);
        
        Path path = Paths.get(currentDirectory + "/minegenkode/src/main/java/uke9/data.txt");
        try (Stream<String> streamOfStrings = Files.lines(path)) {
            streamOfStrings.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        int numberOfLinesToBeRead = 2;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stream<String> stream = in.lines().limit(numberOfLinesToBeRead);
        stream.forEach(System.out::println);
    

    }
}
