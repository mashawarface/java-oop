import java.io.BufferedReader;
import java.util.Map;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Not enough arguments");
        }

        String txtFile = args[0];
        String csvFile = args[1];

        ReadFile rf = new ReadFile(txtFile);
        WriteFile wf = new WriteFile(csvFile, rf.getSortMap(), rf.getWordsCount());
    }
}