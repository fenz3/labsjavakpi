package javalab4;
/**
 * Represents a single letter with additional operations.
 */
public class Letter {

    // The character representing this letter
    private final char value;

    /**
     * Constructs a Letter object with a given character.
     *
     * @param value The character of the letter.
     */
    public Letter(char value) {
        this.value = value;
    }

    /**
     * Gets the character value of the letter.
     *
     * @return The character value.
     */
    public char getValue() {
        return value;
    }

    /**
     * Converts the letter to uppercase.
     *
     * @return A new Letter object with an uppercase character.
     */
    public Letter toUpperCase() {
        return new Letter(Character.toUpperCase(value));
    }

    /**
     * Converts the letter to lowercase.
     *
     * @return A new Letter object with a lowercase character.
     */
    public Letter toLowerCase() {
        return new Letter(Character.toLowerCase(value));
    }

    /**
     * Replaces the letter with another character if it matches the target.
     *
     * @param target      The character to be replaced.
     * @param replacement The replacement character.
     * @return A new Letter object with the replaced character if applicable.
     */
    public Letter replace(char target, char replacement) {
        return new Letter(value == target ? replacement : value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
