/**
 * (Count characters, words, and lines in a file) Write a program that will count
 * the number of characters, words, and lines in a file. Words are separated by
 * whitespace characters. The file name should be passed as a command-line
 * argument.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the absolute directory of the file you would like to read: ");
        String absDir = sc.nextLine();
        readAndCount(absDir);
        sc.close();
    }

    public static void readAndCount(String userDir) {
        File userFile = new File(userDir);
        int totalWords = 0;
        int totalChars = 0;
        int totalLines = 0;

        try (Scanner fileScanner = new Scanner(userFile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                //Keep track of the number of lines
                totalLines++;

                if (!line.isEmpty()) {
                    // Count words
                    String[] words = line.split("\\s+"); // split by 1+ spaces
                    totalWords += words.length;

                    // Count characters
                    totalChars += line.replaceAll("\\s+", " ").length();

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found at that path");
        }
        // Prints words, characters and number of lines
        System.out.println("Total words: " + totalWords);
        System.out.println("Total characters: " + totalChars);
        System.out.println("Total lines: " + totalLines);
    }
}
