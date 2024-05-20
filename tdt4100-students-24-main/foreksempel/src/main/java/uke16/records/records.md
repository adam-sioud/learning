# Records i Java
Gir ikke noe "nytt", men gjør det enkelt å definere klasser/objekter som bare skal holde på data​
- Klasse-definisjonen ser ut som en konstruktør:
```java
record Data(String label, int x, int y) {}
```

- Alle felt er automatisk private og final​
- Getters genereres automatisk for alle felt​ (men ikke setters!)
- default public konstruktør med ett argument for hvert felt​
- Automatisk generert Equals, hashCode, toString som tar med alle felt 
- En kan legge til valideringskode i konstruktøren. NB! Legg merke til syntaks.

```java
record Person(String name, String address) {
    public Person {
        if (name == null || address == null) {
            throw new IllegalArgumentException("Name and address must be non-null");
        }
    }   
}
```
