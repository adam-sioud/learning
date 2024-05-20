package uke7.comparator;

//interface 
import java.util.*; 

class Person implements Comparable<Person> { 
	String fornavn; 
	String etternavn;
	int age; 
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return etternavn + " " + fornavn;
	}
	
	// Constructor 
	public Person(String fornavn, String etternavn, int alder) 
	{ 
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.age = alder; 
	} 
	
	public String toString() 
	{ 
		return this.fornavn + " " + this.etternavn + "\t"+ this.age; 
	}
	
	
	public static void main (String[] args) 
	{ 
		List<Person> personer = new ArrayList<Person>(); 
		personer.add(new Person("Jens", "Hansen", 12)); 
		personer.add(new Person("Ida", "Hansen", 33)); 
		personer.add(new Person("Småen", "Sund", 3)); 
		personer.add(new Person("Karl", "Stiansen", 32)); 
		personer.add(new Person("Karoline", "Sund", 17)); 
		personer.add(new Person("Karolinus", "Sund", 17)); 
		personer.add(new Person("Farfar", "Sund", 133)); 
		
		// De tre følgende linjene viser hvor dere skal i løpet av noen få uker.
		// Alle personer over 17 år i en liste
		System.out.println(personer.stream().filter(p->p.getAge()>17).toList());

		// Summen av alle over 17 år sin alder
		System.out.println(personer.stream().filter(p->p.getAge()>17).mapToInt(p -> p.getAge()).sum());

		// Sortert etter alder
		System.out.println(personer.stream().sorted((p1, p2) -> p1.getAge() - p2.getAge()).toList());

		// Så til der vi er i dag:
		System.out.println("Usortert");
		for (Person person : personer) {
			System.out.println(person);
		}
				
		// // Her bruker vi et ekstern comparatorobjekt til hjelp med sorteringen.
		// System.out.println("\nSortert etter alder"); 
		// Collections.sort(personer, new PersonAgeComparator()); 
		// for (Person person : personer) {
		// 	System.out.println(person);
		// }
	
		// Standard sammenlikner er implementert med "implements Comparable"
		// Collection sin statiske metode gjennomfører selve sorteringen, men
		// DU må fortelle den hva som er rett mhp mer og mindre verd.
		// Collections.sort(personer);  
		// System.out.println("\nSortert etter navn"); 
		// for (Person person : personer) {
		// 	System.out.println(person);
		// }

		
	}
	
	@Override
	public int compareTo(Person p) { // pga implements Comparable
		
		int sort = this.etternavn.compareTo(p.etternavn);
		if (sort > 0) {
			return 1;
		}
		else if (sort < 0) {
			return -1;
		}
		else {
			return this.fornavn.compareTo(p.fornavn);
		}
	}
	
} 

