package of1.lf;

public class Car {

    String model;
    String brand;
    String licensePlate;
    int productionYear;
    double distanceDriven;
    double speed;

    public Car(String model, String brand, String licensePlate, int productionYear, double distanceDriven) {
        this.model = model;
        this.brand = brand;
        this.licensePlate = licensePlate;
        this.productionYear = productionYear;
        this.distanceDriven = distanceDriven;
        this.speed = 0;
    }

    void accelerate(double amount) {
        if (amount <= 0) {
            return;
        }

        this.speed += amount;
    }

    void brake(double amount) {
        if (amount <= 0) {
            return;
        }

        this.speed = Math.max(0, this.speed - amount);
    }

    double getSpeed() {
        return this.speed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public double getDistanceDriven() {
        return distanceDriven;
    }

    void driveDistance(double amount) {
        if (amount <= 0) {
            return;
        }

        this.distanceDriven += amount;
    }

    @Override
    public String toString() {
        return "Car [model=" + model + ", brand=" + brand + ", licensePlate=" + licensePlate + ", productionYear="
                + productionYear + ", distanceDriven=" + distanceDriven + ", speed=" + this.getSpeed() + "]";
    }

    public static void main(String[] args) {
        // Modell, Produsent, Registeringsnummer, Produksjonsår, Kilometerstand
        Car car = new Car("S-MAX", "Ford", "AQ12345", 2019, 356.0);
        System.out.println(car);

        car.driveDistance(256.0);
        System.out.println(car);

        car.accelerate(50);
        car.brake(20);
        System.out.println(car);

        car.brake(60);
        System.out.println(car);
    }

}
