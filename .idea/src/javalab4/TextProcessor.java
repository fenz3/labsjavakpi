package javalab4;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Main processing class for sorting words in the text.
 */
public class TextProcessor {

    /**
     * Sorts words in the text by the number of occurrences of the given letter.
     *
     * @param text   The input text to be processed.
     * @param letter The letter to count in each word.
     */
    public void execute(String text, char letter) {
        Text parsedText = new Text(text);

        // Collect all words from all sentences
        List<Word> words = parsedText.getSentences().stream()
                .flatMap(sentence -> sentence.getWords().stream())
                .collect(Collectors.toList());

        // Sort words by letter occurrences
        words.sort((word1, word2) -> Integer.compare(
                word1.countOccurrencesOf(letter),
                word2.countOccurrencesOf(letter)
        ));

        // Output sorted words
        System.out.println("Words sorted by occurrences of the letter '" + letter + "':");
        for (Word word : words) {
            System.out.println(word.getValue());
        }
    }

    public static void main(String[] args) {
        String inputText = "Програмування це цікаво і корисно. Комп'ютери є невід'ємною частиною сучасного світу.";
        String inputText1 = "Швидкий коричневий лис стрибає через ледачого собаку, залишаючи сліди на вологій землі після дощу.";
//        String inputText1 = "Незважаючи на складність завдання, наполегливість та систематична робота завжди приносять успіх у довгостроковій перспективі. ";
//        String inputText1 = "Розвиток технологій дозволяє людству досягати висот, про які ще декілька десятиліть тому можна було тільки мріяти.";

        char letter = 'а';

        TextProcessor processor = new TextProcessor();
        processor.execute(inputText, letter);
    }
}
