package uke16.records;

import java.util.Arrays;

public record Person(String name, String address) {
    public Person {
        if (name == null || address == null) {
            throw new IllegalArgumentException("Name and address must be non-null");
        }
        
    }

    public static void main(String[] args) {
        Person p1 = new Person("Per", "Lia 1");
        Person p2 = new Person("Oda", "Dalen 3");
        Person p3 = new Person("Per", "Lia 2");
        Person p4 = new Person("Per", "Lia 1");
        
        try {
            Person p5 = new Person(null, "Lia 1");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(p1.equals(p4));
        System.out.println(p1.equals(p3));

        //Q: How do I make array of persons p1 to p4?
        Person[] persons = {p1, p2, p3, p4};
   
        //Sorter array etter navn
        Arrays.sort(persons, (a, b) -> a.name().compareTo(b.name()));
        //print array
        for (Person p : persons) {
            System.out.println(p);
        }
    }
}
