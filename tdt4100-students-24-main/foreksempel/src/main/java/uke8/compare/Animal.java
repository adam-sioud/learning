package uke8.compare;

import java.util.ArrayList;
import java.util.Collection;

public class Animal {
    
    String type;
    int age, feet;
    
    public Animal(String type, int age, int feet) {
        this.type = type;
        this.age = age;
        this.feet = feet;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public int getFeet() {
        return feet;
    }

    public static void main(String[] args) {
        Collection<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Katt", 3, 4));
        animals.add(new Animal("Hund", 5, 4));
        animals.add(new Animal("Sau", 12, 4));
        animals.add(new Animal("Kylling", 1, 2));
        animals.add(new Animal("Tusenbein", 2, 1300));
    }
}
