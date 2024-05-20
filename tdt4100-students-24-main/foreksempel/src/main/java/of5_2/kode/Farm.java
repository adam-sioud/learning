package of5_2.kode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Farm {

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


        


    }
}
