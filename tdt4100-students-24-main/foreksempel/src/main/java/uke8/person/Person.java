package uke8.person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// En klasse Person som itererer over barna sine, en samling med Person.
// Den gjør det gjennom å returnere samlingen sin iterator(), siden en samling kan dette allerede.
public class Person implements Iterable<Person>{

	Collection<Person> children = new ArrayList<>();

	@Override
	public String toString() {
		return String.format("%s (%d)",name, age);
	}

	String name;
	int age;
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public void addChild(Person child) {
		children.add(child);
	}

	@Override
	public Iterator<Person> iterator() {
		return children.iterator();
	}
	
	
	public static void main(String[] args) {
		Person p = new Person("Børge", 49);
		Person j = new Person("Jørn", 16);
		Person h = new Person("Håvard", 14);
		
		p.addChild(j);
		p.addChild(h);
		
		// Jeg kan skrive ut barna her, men det er fordi de ikke er sperret. Jeg er jo inni Personklassen.
		// Her er det mest for å vise hvordan det ser ut.
		System.out.println(p.children);
		
		// System.out.println("-----------------");

		for (Person barn : p) {
			System.out.println(barn);
		}

		System.out.println("-----------------");
		Iterator<Person> pi = p.iterator();
		while (pi.hasNext()) {
			Person barn = pi.next();
			System.out.println(barn);
		}
		

	}
}
