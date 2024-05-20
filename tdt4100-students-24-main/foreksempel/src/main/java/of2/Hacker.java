package of2;

public class Hacker {

    public static void main(String[] args) {
        Car matheasBil = new Car("Toyota", "Model K", "AQ99999", 2015, 1000);
        System.out.println(matheasBil);

        matheasBil.brand = "Mercedes";

        System.out.println(matheasBil);

    }

}
