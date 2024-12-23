package javalab5;

/**
 * Abstract base class representing a toy.
 * Contains common attributes and methods for all toys.
 */
public abstract class Toy {
    protected String name;        // Toy name
    protected double price;       // Toy price
    protected int ageGroup;       // Recommended age group (e.g., 3, 6, 10 years)

    /**
     * Constructor for the Toy class.
     *
     * @param name     The name of the toy.
     * @param price    The price of the toy.
     * @param ageGroup The age group for the toy.
     */
    public Toy(String name, double price, int ageGroup) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.name = name;
        this.price = price;
        this.ageGroup = ageGroup;
    }

    /**
     * Gets the toy name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the toy price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the recommended age group.
     */
    public int getAgeGroup() {
        return ageGroup;
    }

    /**
     * Abstract method to display toy details.
     */
    public abstract void display();
}

