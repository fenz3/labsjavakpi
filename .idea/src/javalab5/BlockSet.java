package javalab5;

/**
 * Represents a block set, which is a specific type of toy.
 * A block set toy consists of a number of pieces.
 */
public class BlockSet extends Toy {

    /** The number of pieces in the block set. */
    private int pieces;

    /**
     * Constructs a new BlockSet object with the specified attributes.
     *
     * @param name      the name of the block set
     * @param price     the price of the block set
     * @param ageGroup  the recommended age group for the block set
     * @param pieces    the number of pieces in the block set
     */
    public BlockSet(String name, double price, int ageGroup, int pieces) {
        super(name, price, ageGroup);
        this.pieces = pieces;
    }

    /**
     * Displays detailed information about the block set.
     * Overrides the display method from the {@link Toy} class.
     */
    @Override
    public void display() {
        System.out.println("Block Set [Name: " + name + ", Price: $" + price
                + ", Age Group: " + ageGroup + "+, Pieces: " + pieces + "]");
    }
}
