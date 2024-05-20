package of5_2.lf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class Farm implements Iterable<Animal>{

    private List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal){
        if(animals.contains(animal)){
            throw new IllegalArgumentException("Animal already added");

        }
        animals.add(animal);
    }

    
    public List<Animal> getAnimals(){
        return new ArrayList<>(animals);
    }

    public int numberOfAnimals(){
        return this.animals.size();
    }

    public Animal getAnimal(int index){
        return animals.get(index);
    }

    @Override
    public Iterator<Animal> iterator() {
        return this.animals.iterator();
    }

    public List<String> getAnimalNames(){
        return this.animals.stream()
            .map((animal) -> animal
            .getName())
            .distinct()
            .toList();
    }

    public static void main(String[] args) {
        Dog Ludo = new Dog("Ludo", 2);
        Chicken Albert = new Chicken("Albert", 1);
        Dog Ollie = new Dog("Ollie", 6);
        Dog Buddy = new Dog("Buddy", 8);
        Chicken Ringo = new Chicken("Ringo", 6);
        Chicken Kjell = new Chicken("Kjell", 5);

        List<Animal> animals = new ArrayList<>(List.of(
            Ludo, Albert, Ollie, Buddy, Ringo, Kjell
            ));

        Farm farm = new Farm();
        farm.addAnimal(animals.get(0));
        farm.addAnimal(animals.get(1));
        farm.addAnimal(animals.get(2));
        farm.addAnimal(animals.get(3));
        farm.addAnimal(animals.get(4));
        farm.addAnimal(animals.get(5));


        //Oppgave 1
        /* Collections.sort(animals);

        for (Animal animal : animals){
            System.out.println(""+animal.getName()+" "+ animal.getAge() + " " + animal.makeSound());

        } */


        /* 

        //Oppgave 2
        for (Animal animal : farm){
            System.out.println(animal.makeSound());
        } */

        //Oppgave 3
        /* Iterator<Animal> iterator  = new YoungAnimalsIterator(farm);
        while(iterator.hasNext()){
            System.out.println(iterator.next().makeSound());

        } */


        //Oppgave 4
        /* Iterator<Animal> iterator = new FilterAnimalsIterator(farm, new DogPredicate());
        while (iterator.hasNext()) {
            System.out.println(iterator.next().makeSound());
        } */


        //Oppgave 5
        /* Iterator<Animal> iterator = new FilterAnimalsIterator(farm, (p -> p.getAge()<=2));
        while (iterator.hasNext()) {
            System.out.println(iterator.next().makeSound());
        } */

        //Oppgave 6
        /* Collections.sort(animals, (animal1, animal2) -> animal1.getName().compareTo(animal2.getName()));
        for (Animal animal : animals){
            System.out.println(animal.makeSound());
        } */

        //Oppgave 7
        /* animals.add(new Dog("Ludo",8)); */

        //Oppgave 8
        /* Iterator<Animal> iterator = new FilterAnimalsIterator(farm, (p -> p.getAge()<=2));
        while (iterator.hasNext()) {
            System.out.println(iterator.next().makeSound());

        farm.getAnimals().stream()
            .filter(new DogPredicate())
            .forEach(animal -> {
                System.out.println(animal.makeSound());}
            ); */
        



















    }

}
