import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.List;

public class WriteFile {
    public WriteFile(String fileName, List<Map.Entry<String, Integer>> words, int wordsCount) {
        writeCsv(fileName, words, wordsCount);
    }

    public void writeCsv(String fileName, List<Map.Entry<String, Integer>> words, int wordsCount) {
        try (BufferedWriter file = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, Integer> entry : words) {
                double frequency = (double) entry.getValue() / wordsCount * 100;
                file.write(String.format("%s;%d;%.1f%%\n", entry.getKey(), entry.getValue(), frequency));
            }
        } catch (IOException e) {
            System.err.println("Error opening file: " + e.getMessage());
        }
    }
}