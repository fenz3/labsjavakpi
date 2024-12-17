package javalab4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a sentence consisting of words.
 */
public class Sentence {

    // List of Word objects forming the sentence
    private final List<Word> words;

    /**
     * Constructs a Sentence object from a string.
     *
     * @param sentence The string to be converted into a Sentence object.
     */
    public Sentence(String sentence) {
        this.words = Arrays.stream(sentence.split("\\s+"))
                .map(Word::new)
                .collect(Collectors.toList());
    }

    /**
     * Gets the list of words in the sentence.
     *
     * @return A list of Word objects.
     */
    public List<Word> getWords() {
        return words;
    }

    /**
     * Gets the string representation of the sentence.
     *
     * @return The sentence as a string.
     */
    public String getValue() {
        return words.stream()
                .map(Word::toString)
                .collect(Collectors.joining(" "));
    }

    /**
     * Converts the sentence to uppercase.
     *
     * @return A new Sentence object with all words in uppercase.
     */
    public Sentence toUpperCase() {
        return new Sentence(this.getValue().toUpperCase());
    }

    /**
     * Converts the sentence to lowercase.
     *
     * @return A new Sentence object with all words in lowercase.
     */
    public Sentence toLowerCase() {
        return new Sentence(this.getValue().toLowerCase());
    }

    /**
     * Replaces all occurrences of a target character in the sentence.
     *
     * @param target      The character to be replaced.
     * @param replacement The replacement character.
     * @return A new Sentence object with the replacements applied.
     */
    public Sentence replace(char target, char replacement) {
        return new Sentence(this.getValue().replace(target, replacement));
    }

    @Override
    public String toString() {
        return getValue();
    }
}