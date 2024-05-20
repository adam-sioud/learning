package uke8.person_lambda_ferdig;

import java.util.function.Function;

public class MapFunction implements Function<Person, String> {
    @Override
    public String apply(Person p) {
        return p.getName();
    }
    public static void main(String[] args) {
        Person p = new Person("Børge", 46);
        Person j = new Person("Jørn", 13);
        Person h = new Person("Håvard", 11);
        System.out.println(new MapFunction().apply(p));
    }

}
