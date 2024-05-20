package uke8.personlambda;

import java.util.Comparator;

public class NameSorter implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
