import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReadFile {
    private BufferedReader file;
    private Map<String, Integer> words;
    private int wordsCount;

    public ReadFile(String fileName) {
        try {
            this.file = new BufferedReader(new FileReader(fileName));
            this.words = new HashMap<>();
            this.wordsCount = 0;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found" + fileName, e);
        }
    }

    public int getWordsCount() {
        return wordsCount;
    }

    public Map<String, Integer> getMap() {
        return words;
    }

    public void readWord() {
        try {
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
        } finally {
            try {
                if (file == null) {
                    file.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing file: " + e.getMessage());
            }
        }
    }



}