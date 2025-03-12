package org.example;

import java.io.*;
import java.util.*;

public class WriteFile {
    private final FileWriter file;

    public WriteFile(String fileName) {
        try {
            this.file = new FileWriter(fileName);
        } catch (IOException e) {
            throw new RuntimeException("Error creating the file " + fileName, e);
        }
    }

    public void writeCsv(List<Map.Entry<String, Integer>> wordList, int wordCount) {
        try (BufferedWriter file = new BufferedWriter(this.file)) {
            for (Map.Entry<String, Integer> entry : wordList) {
                double frequency = (double) entry.getValue() / wordCount * 100;
                file.write(String.format("%s;%d;%.1f%%\n", entry.getKey(), entry.getValue(), frequency));
            }
        } catch (IOException e) {
            System.err.println("Error opening file: " + e.getMessage());
        }
    }
}