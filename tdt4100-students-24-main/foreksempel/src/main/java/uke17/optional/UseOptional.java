package uke17.optional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class UseOptional {

    public static void main(String[] args) {
        
        Optional<String> o = Optional.of("Hello");
        o.ifPresent(s -> System.out.println(s));
        
        String name = null;
        try {
            Optional<String> name_opt = Optional.of(name);
        } catch (NullPointerException e) {
            System.out.println("Name is null");
        }
        
        Optional<String> name_opt = Optional.ofNullable(name); // Ok
        System.out.println(name_opt.isEmpty());
        System.out.println(name_opt.isPresent());

        // Hele poenget med Optional er borte hvis en bruker get() metoden uten å sjekke
        // om verdien er tilstede. Da kan det like gjerne brukes null.
        
        System.out.println(name_opt.orElse("World"));
        System.out.println(name_opt.orElseGet(() -> "World"));
        try {
            System.out.println(name_opt.orElseThrow());
        } catch (NoSuchElementException e) {
            System.out.println("No value");
        }
        
        // Where is optional used in Java standard libraries?
        // Optional is used in Java standard libraries to avoid null pointer exceptions.
    
        // Optional used in streams
        List<String> list = Arrays.asList("a", "b", "c");
        Optional<String> first = list.stream().findFirst();
        System.out.println(first.orElse("No value"));
        // Linjen over har samme effekt som
        try {
            System.out.println(first.get());
        } catch (NoSuchElementException e) {
            System.out.println("No value");
        }

        // Pakke inn returverdi som kan være null med Optional
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        Optional<String> value = Optional.ofNullable(map.get("key"));
        System.out.println(value.orElse("No value"));
        
        // Hvis man vet hva en vil returnere hvis verdien ikke er tilstede kan en bruke
        // getOrDefault metoden til Map
        String s = map.getOrDefault("key", "Empty");
        

        // Optional used in reduce, max, min
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> sum = numbers.stream().reduce((a, b) -> a + b);
        Optional<Integer> max = numbers.stream().max((a,b)->a-b);
        System.out.println(max.orElse(0));
    
        System.out.println(o.get());
        System.out.println(o.isPresent());
        System.out.println(o.isEmpty());
        System.out.println(o.orElse("World"));
        System.out.println(o.orElseGet(() -> "World"));
        System.out.println(o.orElseThrow());
        System.out.println(o.orElseThrow(() -> new RuntimeException("No value")));
        System.out.println(o.map(x -> x.toUpperCase()));
        System.out.println(o.flatMap(x -> Optional.of(x.toUpperCase())));
        System.out.println(o.filter(x -> x.length() > 5));
        
    }
}

