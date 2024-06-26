package uke7.fasit_personcomparator;

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

	public static void main(String[] args) 
	{ 
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

		// Kan også kalles slik:
		personer.sort(null); // Bruker naturlig ordning definert ved compareTo-metoden

		//Collections.sort(personer, Collections.reverseOrder());
		personer.sort(Collections.reverseOrder());
		System.out.println("\nSortert etter navn, reversert:"); 
		for (Person person : personer) {
			System.out.println(person);
		}

		System.out.println("\nSortert etter alder"); 
		// Her bruker vi en annen comparator enn den vanlige
		Collections.sort(personer, new PersonAgeComparator()); 
		for (Person person : personer) {
			System.out.println(person);
		}


	}
}


