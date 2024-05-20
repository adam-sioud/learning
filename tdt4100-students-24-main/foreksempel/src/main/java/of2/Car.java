package of2;

public class Car {

    private String brand;
    private String model;
    private String regNum;
    private int productionYear;
    private double weight;
    private double kmDriven;

    public Car(String brand, String model, String regNum, int productionYear, double weight) {
        this.model = model;
        this.brand = brand;
        this.regNum = regNum;
        this.productionYear = productionYear;
        this.weight = weight;
        this.kmDriven = 0.0;
    }

    public Car(String brand, String model, String regNum, int productionYear, double weight, double kmDriven) {
        this(brand, model, regNum, productionYear, weight);
        this.kmDriven = kmDriven;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", model=" + model + ", regNum=" + regNum + ", productionYear=" + productionYear
                + "]";
    }

    public static void main(String[] args) {
        Car car = new Car("Tesla", "Model K", "AQ12345", 2015, 1000);
        System.out.println(car);

        Car matheasBil = new Car("Toyota", "Model K", "AQ99999", 2015, 1000);
        System.out.println(matheasBil);

        matheasBil.brand = "Mercedes";

        System.out.println(matheasBil);

    }
}
