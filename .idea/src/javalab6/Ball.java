package javalab6;

/**
 * Represents a ball, which is a specific type of toy.
 * A ball toy has an additional attribute that specifies its type.
 */
public class Ball extends Toy {

    /** The type of the ball (e.g., soccer, basketball, rubber). */
    private String type;

    /**
     * Constructs a new Ball object with the specified attributes.
     *
     * @param name      the name of the ball
     * @param price     the price of the ball
     * @param ageGroup  the recommended age group for the ball
     * @param type      the type of the ball
     */
    public Ball(String name, double price, int ageGroup, String type) {
        super(name, price, ageGroup);
        this.type = type;
    }

    /**
     * Displays detailed information about the ball.
     * Overrides the display method from the {@link Toy} class.
     */
    @Override
    public void display() {
        System.out.println("Ball [Name: " + name + ", Price: $" + price
                + ", Age Group: " + ageGroup + "+, Type: " + type + "]");
    }
}
