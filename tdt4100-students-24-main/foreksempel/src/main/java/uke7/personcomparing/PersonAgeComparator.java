package uke7.personcomparing;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person> {


    @Override
    public int compare(Person a, Person b) {
        return a.getAge() - b.getAge();
    }
    
}
