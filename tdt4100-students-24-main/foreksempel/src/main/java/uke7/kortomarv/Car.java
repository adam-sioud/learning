package uke7.kortomarv;

// Subclass inherits from Vehicle
class Car extends Vehicle {
    void beep() {
        System.out.println("Beep beep");
    }

    public static void main(String[] args) {
        // Usage
        Car myCar = new Car();
        myCar.move();  // Inherited method
        myCar.beep();  // Subclass specific method 
    }
}