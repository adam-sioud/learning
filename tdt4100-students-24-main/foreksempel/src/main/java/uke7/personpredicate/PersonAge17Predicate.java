package uke7.personpredicate;

import java.util.function.Predicate;

public class PersonAge17Predicate implements Predicate<Person> {
    
    
    public boolean test(Person p) {
        return p.getAge() > 17;
    }
}
