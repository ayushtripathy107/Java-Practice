class Car {
    // Attributes (Fields)
    private String model;
    private int year;

    // Constructor to initialize variables
    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    // Method to display information
    public void displayDetails() {
        System.out.println("Car Model: " + model + ", Year: " + year);
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating an object instance of the Car class
        Car myCar = new Car("Toyota Corolla", 2024);
        myCar.displayDetails();
    }
}
