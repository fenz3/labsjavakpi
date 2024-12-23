package javalab5;

/**
 * Represents a doll, which is a specific type of toy.
 * A doll has additional attributes, such as the material it is made of.
 */
public class Doll extends Toy {

    /** The material the doll is made of (e.g., plastic, fabric). */
    private String material;

    /**
     * Constructs a new Doll object with the specified attributes.
     *
     * @param name      the name of the doll
     * @param price     the price of the doll
     * @param ageGroup  the recommended age group for the doll
     * @param material  the material of the doll
     */
    public Doll(String name, double price, int ageGroup, String material) {
        super(name, price, ageGroup);
        this.material = material;
    }

    /**
     * Displays detailed information about the doll.
     * Overrides the display method from the {@link Toy} class.
     */
    @Override
    public void display() {
        System.out.println("Doll [Name: " + name + ", Price: $" + price
                + ", Age Group: " + ageGroup + "+, Material: " + material + "]");
    }
}
