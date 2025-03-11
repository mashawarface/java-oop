import java.io.*;
import java.util.*;

public class ReadFile {
    private final Map<String, Integer> words;
    private int wordsCount;

    public ReadFile(String fileName) {
        this.words = new HashMap<>();
        this.wordsCount = 0;
        readWord(fileName);
    }

    public int getWordsCount() {
        return wordsCount;
    }

    public Map<String, Integer> getMap() {
        return words;
    }

    public void readWord(String fileName) {
        try (BufferedReader file = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = file.readLine()) != null) {
                line = line.toLowerCase();

                String[] wordsArray = line.split("[^a-zA-Z0-9']+");

                for (String word : wordsArray) {
                    if (!word.isEmpty()) {
                        words.put(word, words.getOrDefault(word, 0) + 1);
                        ++wordsCount;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file" + e.getMessage(), e);
        }
    }

    public void printWords() {
        for (String word : words.keySet()) {
            System.out.println(word + " : " + words.get(word));
        }
    }

    public List<Map.Entry<String, Integer>> getSortMap() {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(words.entrySet());

        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        return entryList;
    }
}