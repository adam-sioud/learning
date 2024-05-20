package uke9.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Pipeline {
    public static void main(String[] args) {
        
        // Fra en Collection lage en liste med Score-objekter. Score blir alle satt til default verdi -1.
        Collection<String> ids = Arrays.asList("Ada", "Odd", "Even", "Dina");
        Collection<Score> scores = ids.stream().map(name -> new Score(name)).collect(Collectors.toList());
        System.out.println(scores);
    

        // Vi kan også lage stream fra en Array på samme måte.
        // Vi kan også forenkle skrivemåten for å generere listen.
        String[] names = new String[] {"Per", "Ida", "Live", "Pål"};
        scores.addAll(Arrays.stream(names).map(Score::new).toList());
        System.out.println(scores);

        // La oss legge til verdier i Score-objektene:
        Random rnd = new Random();
        scores.stream().forEach(s -> s.setValue(rnd.nextInt(3))); // forEach tar en Consumer som argument
        
        // Dette kan også gjøres slik:
        scores.forEach(s -> s.setValue(rnd.nextInt(3)));  
        // ... eller slik:
        for (Score s : scores) {
            s.setValue(rnd.nextInt(3));
        }
        System.out.println(scores);

        // En fordel med stream, er at den er designet for å lett koble sammen flere operasjoner
        long noWithScore2 = scores.stream().filter(s-> s.getValue() == 2).count();
        System.out.println(noWithScore2);

        // Hvem hadde score 2?
        Collection<String> scorers = scores.stream().filter(s-> s.getValue() == 2).map(s->s.getId()).toList();
        System.out.println(scorers);
        
        // La oss lage en map fra id til sum av scores
        Map<Integer, List<Score>> scoresAsMap = scores.stream().collect(Collectors.groupingBy(Score::getValue));
        System.out.println(scoresAsMap);

        // Mange metoder kan brukes direkte på collections
        List<String> nyeNavn = Arrays.asList("Ada", "Bo", "Eva");
        nyeNavn.forEach(System.out::println);

        // En bruker ikke streams til å slette noe fra input.     
        
    }
}
