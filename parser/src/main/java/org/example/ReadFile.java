package org.example;

import java.io.*;
import java.util.*;

public class ReadFile {
    private final FileReader file;
    private final Map<String, Integer> wordMap;
    private int wordCount;

    public ReadFile(String fileName) {
        try {
            this.file = new FileReader(fileName);
            this.wordMap = new HashMap<>();
            this.wordCount = 0;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found" + fileName, e);
        }
    }

    public void readWord() {
        try (BufferedReader file = new BufferedReader(this.file)) {
            String line;

            while ((line = file.readLine()) != null) {
                line = line.toLowerCase();

                String[] wordArray = line.split("[^a-zA-Z0-9']+");

                for (String word : wordArray) {
                    if (!word.isEmpty()) {
                        wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
                        ++wordCount;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file" + e.getMessage(), e);
        }
    }

    public int getWordCount() {
        return wordCount;
    }

    public List<Map.Entry<String, Integer>> getSortMap() {
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordMap.entrySet());

        wordList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        return wordList;
    }
}