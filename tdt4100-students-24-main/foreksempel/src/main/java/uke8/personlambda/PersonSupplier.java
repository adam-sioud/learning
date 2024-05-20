package uke8.personlambda;

import java.util.Random;
import java.util.function.Supplier;

public class PersonSupplier implements Supplier<Person>{

    @Override
    public Person get() {
        Random rand = new Random();
        return new Person("Randi", rand.nextInt(1, 100));
    }
 
        public static void main(String[] args) {
            Supplier<Person> supplier = new PersonSupplier();

            for (int i = 0; i < 100; i++) {
                System.out.println(supplier.get());
            }
        }

}
