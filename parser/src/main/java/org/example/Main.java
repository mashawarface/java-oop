package org.example;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Not enough arguments");
        }

        String textName = args[0];
        String csvName = args[1];

        ReadFile textFile = new ReadFile(textName);
        WriteFile csvFile = new WriteFile(csvName);

        textFile.readWord();
        csvFile.writeCsv(textFile.getSortMap(), textFile.getWordCount());
    }
}