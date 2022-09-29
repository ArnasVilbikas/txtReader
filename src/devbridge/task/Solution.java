package devbridge.task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        //Important - change the directory of txt file to desired one
        readFileLineByLine("d:\\temp\\StringFile.txt");
    }

    private static void readFileLineByLine(String filename){
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            while (line != null) {
                if(doesConsistOfGreaterThanTen(line)){
                    System.out.println(line);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Boolean doesConsistOfGreaterThanTen(String currentLine) {
        List<Integer> allNumbers = retrieveNumberSequences(currentLine);

        for (int i : allNumbers) {
            if (i >= 10) {
                return true;
            }
        }
        return false;
    }

    private static List<Integer> retrieveNumberSequences(String currentLine){
        List<Integer> numberSequences = new ArrayList<>();
        try(Scanner scanner = new Scanner(currentLine).useDelimiter("[^\\d]+")) {
            while (scanner.hasNextInt()) {
                numberSequences.add(scanner.nextInt());
            }
            return numberSequences;
        }
    }
}
