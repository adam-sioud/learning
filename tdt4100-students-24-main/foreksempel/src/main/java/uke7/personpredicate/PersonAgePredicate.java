package uke7.personpredicate;

import java.util.function.Predicate;

public class PersonAgePredicate implements Predicate<Person> {
    int age;

    public PersonAgePredicate(int age) {
        this.age = age;
    }

    public boolean test(Person p) {
        return p.getAge() < age;
    }
}
