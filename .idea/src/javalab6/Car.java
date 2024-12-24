package javalab6;

/**
 * Represents a car, which is a specific type of toy.
 * A car toy has additional attributes, such as its size.
 */
public class Car extends Toy {

    /** The size of the car toy (e.g., small, medium, large). */
    private String size;

    /**
     * Constructs a new Car object with the specified attributes.
     *
     * @param name      the name of the car toy
     * @param price     the price of the car toy
     * @param ageGroup  the recommended age group for the car toy
     * @param size      the size of the car toy
     */
    public Car(String name, double price, int ageGroup, String size) {
        super(name, price, ageGroup);
        this.size = size;
    }

    /**
     * Displays detailed information about the car toy.
     * Overrides the display method from the {@link Toy} class.
     */
    @Override
    public void display() {
        System.out.println("Car [Name: " + name + ", Price: $" + price
                + ", Age Group: " + ageGroup + "+, Size: " + size + "]");
    }
}
