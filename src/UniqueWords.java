import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Find number of unique words in a file.
 *
 * @author Benjapol Worakan
 */
public class UniqueWords {
    /**
     * Entry point, will read input String from a file.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        try {
            System.out.println(countUniqueWords(readFile("input_words.txt")));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found.");
        }
    }

    /**
     * Read String from a text file.
     *
     * @param path path to the file
     * @return String of text from the file
     * @throws FileNotFoundException if the file on the given path is not found
     */
    private static String readFile(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        String input = "";
        while (scanner.hasNextLine()) {
            input += scanner.nextLine();
            input += "\n";
        }
        return input;
    }

    /**
     * Count unique words in the given String.
     * <p>
     * Works by case-insensitvely putting words with punctuation removed into a Set.
     *
     * @param input the String to be counted for unique words
     * @return numbers of unique words.
     */
    private static int countUniqueWords(String input) {
        Set<String> uniqueWords = new HashSet<>(); // HashSet is fastest of all Sets.
        Collections.addAll(uniqueWords, input.replaceAll("\\p{P}", "").toLowerCase().split("\\s+"));
        return uniqueWords.size();
    }
}
