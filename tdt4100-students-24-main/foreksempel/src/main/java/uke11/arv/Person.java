package uke11.arv;

import java.util.ArrayList;
import java.util.Collection;

public class Person {

	private String name;

	public Person(final String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	

	public void setName(final String name) {
		checkName(name);  
		this.name = name;
	}

	@Override
	public String toString() {
		return this.getName();
	}


	// Trenger ikke returnere noe, den utløser unntak hvis den finner noe.
	// Unntaket skrives ikke automatisk ut, men det skrives ut der en fanger opp feilen,
	// se catch i main.
	private void checkName(final String name) {
		for (int i = 0; i < name.length(); i++) {
			final char c = name.charAt(i);
			if (! (Character.isLetter(c) || " -".indexOf(c) >= 0)) {
				throw new NameValidationException(this, name);
			}
		}
	}

	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public static void main(final String[] args) {
		try {
			// Lysark 16
			Person p = new Person("Per)(/)((&))");
			System.out.println("objekt: "+p);


			// Lysark 18
			Collection<Person> c = new ArrayList<>();
			c.add(p);
			System.out.println("inneholder p: "+c.contains(p)); // Nope
			System.out.println(c.contains(new Person("Anne"))); // Nope
			System.out.println("likt navn: "+c.contains(new Person("Per")));  // Yay, siden alt vi sjekker for likhet er navnet.
			// Husket du å implementere equals og hashcode?

			// Lysark NameValidationException
			Person p2 = new Person("Per Berg-Hansen"); // Lovlig grunnet indexOf-sjekken.
			// p2.setName("P£r Hansen");
			// Person p3 = new Person("Per@Hansen"); // ulovlig
			System.out.println(p.getName());
		} catch (final NameValidationException e) {
			// Test F12 (go to definition) på getLocalizedMessage under. Da ender du opp på 
			// Throwable-klassen.
			// Denne igjen kaller getMessage(). Den er overskrevet i NameValidationException,
			// som da vil skygge over Throwableklassen sin getMessage(). På den måten skrives
			// den ut. Se foil 25 om arv.
			System.out.println("Feil: "+e.getLocalizedMessage()); 
		}
	}

}
