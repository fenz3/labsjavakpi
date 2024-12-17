import java.util.*;

/**
 * A class that processes text and sorts its words by the number of occurrences of a given letter.
 */
public class LabWork2 {

    // Field to store the input text
    private String textVariable;

    /**
     * Constructor to initialize the textVariable and sort the words by the number of occurrences of the given letter.
     *
     * @param text   The input text to process.
     * @param letter The letter to count in each word.
     */
    public LabWork2(String text, char letter) {
        this.textVariable = text;

        // Sort words by the number of occurrences of the specified letter
        List<String> sortedWords = sortWordsByLetterCount(textVariable, letter);

        // Output the sorted words
        System.out.println("Words sorted by occurrences of the letter '" + letter + "':");
        for (String word : sortedWords) {
            System.out.println(word); // Print each word
        }
    }

    /**
     * Sorts the words in a String by the number of occurrences of the specified letter.
     *
     * @param text   The input text as a String.
     * @param letter The letter to count in each word.
     * @return A list of words sorted by the number of occurrences of the specified letter.
     */
    protected List<String> sortWordsByLetterCount(String text, char letter) {
        // Split the text into words based on whitespace
        String[] wordsArray = text.split("\\s+");

        // Convert the array of words into a list
        List<String> wordList = new ArrayList<>(Arrays.asList(wordsArray));

        // Sort the words by the number of occurrences of the specified letter
        wordList.sort(Comparator.comparingInt(word -> countLetterOccurrences(word, letter)));

        return wordList;
    }

    /**
     * Counts the number of occurrences of the specified letter in a word.
     *
     * @param word   The word in which to count the occurrences of the letter.
     * @param letter The letter to count.
     * @return The number of occurrences of the specified letter in the word.
     */
    protected int countLetterOccurrences(String word, char letter) {
        int count = 0;

        // Iterate through each character in the word
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                count++;
            }
        }
        return count;
    }

    /**
     * Main method to demonstrate the functionality of the LabWork2 class.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Input text to process
        String inputText = "Програмування це цікаво і корисно. Комп'ютери є невід'ємною частиною сучасного світу.";
        // The letter to count in the words
        char letter = 'а';

        // Create a LabWork2 instance to process the text
        new LabWork2(inputText, letter);
    }

    /**
     * Validates the input text to ensure it meets certain criteria.
     *
     * @param text The text to validate.
     * @throws IllegalArgumentException If the text is null, empty, or consists only of whitespace or punctuation.
     */
    private static void validateText(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Text cannot be empty or consist only of whitespace.");
        }
        if (text.matches("[\\s!,.?;]*")) {
            throw new IllegalArgumentException("Text cannot consist only of punctuation marks.");
        }
    }
}
