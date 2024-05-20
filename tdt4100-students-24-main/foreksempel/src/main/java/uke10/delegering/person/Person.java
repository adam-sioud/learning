package uke10.delegering.person;

import java.util.ArrayList;
import java.util.List;

public class Person {

	// Oversikten over barn er delegert til et liste-objekt.
	// Referansen er komposisjon
	// så dersom Person-objektet slettes så vil også barna slettes.
	// Hvis det finnes referanser til children-objektet andre steder, så vil 
	// ikke listen slettes. (Det måtte være kode i Person-klassen pga innkapslingenen)
	// Det ville jo være dog være uvanlig/unaturlig.

	List<Person> children = new ArrayList<>();
	
	@Override
	public String toString() {
		return String.format("%s (%d)",name, age);
	}

	String name;
	int age;
	

	int getChildCount() { return children.size();}

	Person getChild(int i) {return children.get(i);}

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
	
	public static void main(String[] args) {
		Person p = new Person("Børge", 46);
		Person j = new Person("Jørn", 13);
		Person h = new Person("Håvard", 11);
		
		p.addChild(j);
		p.addChild(h);
		
		System.out.println(p.getChildCount());
		System.out.println(p.getChild(1));

	}
}
