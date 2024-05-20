package uke7.comparator;

import java.util.Comparator;

public class EnkelPersonSortering implements Comparator<EnkelPerson>{

    @Override
    public int compare(EnkelPerson o1, EnkelPerson o2) {
       return o1.getNavn().compareTo(o2.getNavn());
    }

    
}
