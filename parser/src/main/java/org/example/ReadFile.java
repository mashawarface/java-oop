package org.example;

import java.io.*;
import java.util.*;

public class ReadFile {
    private final FileReader file;
    private final Map<String, Integer> words;
    private int wordsCount;

    public ReadFile(String fileName) {
        try {
            this.file = new FileReader(fileName);
            this.words = new HashMap<>();
            this.wordsCount = 0;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found" + fileName, e);
        }
    }

    public void readWord() {
        try (BufferedReader file = new BufferedReader(this.file)) {
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

    public int getWordsCount() {
        return wordsCount;
    }

    public List<Map.Entry<String, Integer>> getSortMap() {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(words.entrySet());

        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        return entryList;
    }
}