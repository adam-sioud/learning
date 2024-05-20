package uke7.personcomparing;

import java.util.ArrayList;
import java.util.Collections;

public class Person implements Comparable<Person> {
    String fornavn;
    String etternavn;
    int age;

    public Person(String fornavn, String etternavn, int age) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.age = age;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public int getAge() {
        return age;
    }
    
	public String toString() {
		return this.fornavn + " " + this.etternavn + "\t"+ this.age; 
	}

	//todo: Implementer følgende
	@Override
	public int compareTo(Person p) { // pga Comparable-interface
		int test = this.etternavn.compareTo(p.getEtternavn()); 
		if (test == 0) {
			return this.fornavn.compareTo(p.getFornavn());
		}
		else {
			return test;
		}
	}
	

    public static void main(String[] args) {
    	ArrayList<Person> personer = new ArrayList<Person>(); 
		personer.add(new Person("Jens", "Hansen", 12)); 
		personer.add(new Person("Ida", "Hansen", 33)); 
		personer.add(new Person("Småen", "Sund", 3)); 

		System.out.println("Usortert");
		for (Person person : personer) {
			System.out.println(person);
		}

		// Standard sammenlikner er implementert med "implements Comparable"
		// Collection sin statiske metode gjennomfører selve sorteringen, men
		// DU må fortelle den hva som er rett mhp mer og mindre verd.
		
		Collections.sort(personer);  
		
		System.out.println("\nSortert etter navn"); 
		for (Person person : personer) {
			System.out.println(person);
		}

		personer.sort(new PersonAgeComparator().reversed());
		System.out.println("\nSortert etter alder"); 
		for (Person person : personer) {
			System.out.println(person);
		}

	}

}    

