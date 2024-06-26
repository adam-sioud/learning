package uke8.personiterable;

public class Person {

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
		//super();
		this.name = name;
		this.age = age;
	}
		
	public boolean isAdult() {
        return age > 17;
    }

	
	public static void main(String[] args) {
		Person p = new Person("Børge", 46);
		Person j = new Person("Jørn", 13);
		Person h = new Person("Håvard", 11);
		System.out.println(p.isAdult());
		
		
	}
}
