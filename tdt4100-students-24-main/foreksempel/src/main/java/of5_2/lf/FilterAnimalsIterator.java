package of5_2.lf;

import java.util.Iterator;
import java.util.function.Predicate;

public class FilterAnimalsIterator implements Iterator<Animal> {
    private int index = 0;
    private Farm farm;
    private Predicate<Animal> animalPredicate;

    public FilterAnimalsIterator(Farm farm, Predicate<Animal> animalPredicate){
        this.animalPredicate = animalPredicate;
        this.farm = farm;

    }

    @Override
    public boolean hasNext() {
        while(index<farm.numberOfAnimals()){
            if(animalPredicate.test(farm.getAnimal(index))){
                return true;
            }
            else{
                index++;
            }
            
        }
        return false;
    }

    @Override
    public Animal next() {
        if(!hasNext()){
            throw new IllegalArgumentException("No more animals in the farm");
        }
        return farm.getAnimal(index++);
    }
}
