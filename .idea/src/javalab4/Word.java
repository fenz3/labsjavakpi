package javalab4;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Represents a word consisting of letters.
 */
public class Word {

    // List of Letter objects forming the word
    private final List<Letter> letters;

    /**
     * Constructs a Word object from a string.
     *
     * @param word The string to be converted into a Word object.
     */
    public Word(String word) {
        this.letters = word.chars()
                .mapToObj(c -> new Letter((char) c))
                .collect(Collectors.toList());
    }

    /**
     * Gets the string representation of the word.
     *
     * @return The word as a string.
     */
    public String getValue() {
        return letters.stream()
                .map(Letter::toString)
                .collect(Collectors.joining());
    }

    /**
     * Counts the number of occurrences of a specific letter in the word.
     *
     * @param targetLetter The letter to count.
     * @return The number of occurrences of the letter.
     */
    public int countOccurrencesOf(char targetLetter) {
        return (int) letters.stream()
                .filter(letter -> letter.getValue() == targetLetter)
                .count();
    }

    /**
     * Converts the word to uppercase.
     *
     * @return A new Word object with all letters in uppercase.
     */
    public Word toUpperCase() {
        return new Word(this.getValue().toUpperCase());
    }

    /**
     * Converts the word to lowercase.
     *
     * @return A new Word object with all letters in lowercase.
     */
    public Word toLowerCase() {
        return new Word(this.getValue().toLowerCase());
    }

    /**
     * Replaces all occurrences of a target character with a replacement character.
     *
     * @param target      The character to be replaced.
     * @param replacement The replacement character.
     * @return A new Word object with the replacements applied.
     */
    public Word replace(char target, char replacement) {
        return new Word(this.getValue().replace(target, replacement));
    }

    @Override
    public String toString() {
        return getValue();
    }
}