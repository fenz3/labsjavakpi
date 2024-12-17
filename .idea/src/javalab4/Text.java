package javalab4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Represents a text consisting of sentences.
 */
public class Text {

    // List of Sentence objects forming the text
    private final List<Sentence> sentences;

    /**
     * Constructs a Text object from a string.
     *
     * @param text The string to be converted into a Text object.
     */
    public Text(String text) {
        this.sentences = Arrays.stream(text.split("(?<=[.!?])\\s*"))
                .map(Sentence::new)
                .collect(Collectors.toList());
    }

    /**
     * Gets the list of sentences in the text.
     *
     * @return A list of Sentence objects.
     */
    public List<Sentence> getSentences() {
        return sentences;
    }

    /**
     * Gets the string representation of the text.
     *
     * @return The text as a string.
     */
    public String getValue() {
        return sentences.stream()
                .map(Sentence::toString)
                .collect(Collectors.joining(" "));
    }

    /**
     * Converts the text to uppercase.
     *
     * @return A new Text object with all sentences in uppercase.
     */
    public Text toUpperCase() {
        return new Text(this.getValue().toUpperCase());
    }

    /**
     * Converts the text to lowercase.
     *
     * @return A new Text object with all sentences in lowercase.
     */
    public Text toLowerCase() {
        return new Text(this.getValue().toLowerCase());
    }

    /**
     * Replaces all occurrences of a target character in the text.
     *
     * @param target      The character to be replaced.
     * @param replacement The replacement character.
     * @return A new Text object with the replacements applied.
     */
    public Text replace(char target, char replacement) {
        return new Text(this.getValue().replace(target, replacement));
    }

    @Override
    public String toString() {
        return getValue();
    }
}
