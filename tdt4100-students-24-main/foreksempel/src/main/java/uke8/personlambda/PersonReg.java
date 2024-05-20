package uke8.personlambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PersonReg implements Iterable<Person> {
    
    List<Person> persons = new ArrayList<>();

    @Override
    public Iterator<Person> iterator() {
        return persons.iterator();
    }

    // Denne er litt søt. Tar inn så mange argumenter en vil, og legger dem til som en liste.
    public void addPersons(final Person...persons) {
		this.persons.addAll(List.of(persons));
	}

    @Override
    public String toString() {
        return persons.toString();
    }


    private void sortPersons(Comparator<Person> comparator) {
        Collections.sort(this.persons, comparator);
    }


    public Person findFirst(Predicate<Person> tester) {
        for (Person person : persons) {
            if (tester.test(person)) {
                return person;
            }
        }
        return null;
    }

    public Collection<Person> findAll(Predicate<Person> tester) {
        Collection<Person> tmpPersons = new ArrayList<>();
        for (Person person : persons) {
            if (tester.test(person)) {
                tmpPersons.add(person);
            }
        }
        return tmpPersons;
    }

    public void forEachPerson(Consumer<Person> consume) {
        for (Person person : persons) {
            consume.accept(person);
        }
    }

    public static void main(String[] args) {
        Person a = new Person("Ada", 14);
        Person b = new Person("Børge", 46);
        Person c = new Person("Cåre", 76);
        Person d = new Person("Dora", 6);
        Person e = new Person("Espen", 50);
        Person f = new Person("Frida", 1);
        Person g = new Person("Geir Kjetil", 12);
        Person h = new Person("Håvard", 13);
        Person i = new Person("Irma", 112);
		Person j = new Person("Jørn", 15);

        PersonReg pr = new PersonReg();
        pr.addPersons(a,b,c,d,e,f,g,h,i,j); // Enkel måte ja!

        System.out.println(pr);
        // Comparator som egen klasse
        pr.sortPersons(new AgeSorter());
        System.out.println(pr);


        // Vi kan lage en Comparatorklasse inni denne klassen!
        // pr.sortPersons(new Comparator<Person>() {

        //     @Override
        //     public int compare(Person o1, Person o2) {
        //         return o1.getName().length()-o2.getName().length();
        //     }
            
        // });

        // Anonym indre klasse

        // Comparator som lambda
        pr.sortPersons((p1, p2) -> p1.getName().length()-p2.getName().length());
        // System.out.println(pr);

        // Kan like gjerne gjøres direkte:


        // Predikater:
        // Finn første person med alder over 17 år
        // System.out.println(pr.findFirst( p -> p.getAge() > 17));

        
        // Alle over 17 år
        // System.out.println(pr.findAll(p -> p.getAge() > 17));
        
        // Finn alle som har navn lenger enn 5 tegn
        System.out.println(pr.findAll(p ->  p.getName().length() > 5));
        
        
        // Consumer: forEachPerson
        // pr.forEachPerson(new Consumer<Person>() {

        //     @Override
        //     public void accept(Person p) {
        //         System.out.println(p.getAge());
        //     }
            
        // });
        pr.forEachPerson(System.out::println);

        
        // Function: getPersonProperties
        
        // Samme som
        
        // Supplier - i egen fil. Men denne limte jeg inn fra ChatGPT! Så da er den vel bra...
        Supplier<String> randomString = () -> {
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            for (int k = 0; k < 10; k++) {
                sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
            }
            return sb.toString();
        };
        
        // System.out.println(randomString.get());
        // System.out.println(randomString.get());
        // System.out.println(randomString.get());
        

        // Coll med navnene på alle over 17 med forløkke

        // Coll med navn på alle over 17 med lambda stream

    }


}
