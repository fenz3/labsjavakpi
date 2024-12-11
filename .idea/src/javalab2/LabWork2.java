import java.util.*;

public class LabWork2 {
    private String textVariable;

    /**
     * Constructor to initialize textVariable and sort words by the number of occurrences of the given letter.
     *
     * @param text   The input text to be processed.
     * @param letter The letter to be counted in each word.
     */
    public LabWork2(String text, char letter) {
        this.textVariable = text;

        List<String> sortedWords = sortWordsByLetterCount(textVariable, letter);

        System.out.println("Words sorted by occurrences of the letter '" + letter + "':");
        for (String word : sortedWords) {
            System.out.println(word);  // Виводимо рядок напряму
        }
    }

    /**
     * Сортує слова у String за кількістю входжень вказаної літери.
     *
     * @param text   Вхідний текст у вигляді String.
     * @param letter Літера, кількість якої потрібно рахувати у кожному слові.
     * @return Список слів, відсортованих за кількістю входжень літери.
     */
    protected List<String> sortWordsByLetterCount(String text, char letter) {
        String[] wordsArray = text.split("\\s+");
        List<String> wordList = new ArrayList<>(Arrays.asList(wordsArray));

        wordList.sort(Comparator.comparingInt(word -> countLetterOccurrences(word, letter)));

        return wordList;
    }

    /**
     * Рахує кількість входжень вказаної літери у слові (String).
     *
     * @param word   Слово у вигляді String, в якому рахується кількість літер.
     * @param letter Літера, яку потрібно рахувати.
     * @return Кількість входжень літери у слові.
     */
    protected int countLetterOccurrences(String word, char letter) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the text: ");
        String inputText = scanner.nextLine();

        validateText(inputText);

        System.out.println("Enter the letter to count: ");
        char letter = scanner.next().charAt(0);

        new LabWork2(inputText, letter);
    }

    private static void validateText(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Text cannot be empty or consist only of whitespace.");
        }
        if (text.matches("[\\s!,.?;]*")) {
            throw new IllegalArgumentException("Text cannot consist only of punctuation marks.");
        }
    }
}
