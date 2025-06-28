/**
 * A program that allows the user to choose between reading and writing integer data to or from a file.
 * Writing a file consists of writing 100 random integers from 0-10000 and is saved to the specified directory
 * Reading a file consists of reading its integer contents and displaying the integers in ascending order
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class ReadAndWriting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            System.out.println("Would you like to write data or read data? enter 'Read' or 'Write'");
            choice = sc.nextLine();

            if (choice.equalsIgnoreCase("write")) {
                System.out.println("--------Writing Data--------");
                System.out.println("Please enter the file name (example.txt): ");
                String fileName = sc.nextLine();
                System.out.println("Please enter the absolute directory path in which you want the file saved: ");
                String fileDir = sc.nextLine();
                writeData(fileName, fileDir);
                break;
            } else if (choice.equalsIgnoreCase("read")) {
                System.out.println("--------Reading Data--------");
                System.out.println("Please enter the file name (example.txt):");
                String fileName = sc.nextLine();
                System.out.println("Please enter the absolute directory path in which you want the file saved: ");
                String fileDir = sc.nextLine();
                readData(fileName, fileDir);
                break;
            } else {
                System.out.println("Please enter only 'Read' or 'Write' case does not matter, try again...");
            }
        } while (true);

        sc.close();
    }

    public static void writeData(String fileName, String dir) {
        // Create the directory
        File directory = new File(dir);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        // Create a file with the full path
        File outputfile = new File(directory, fileName);

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputfile))) {

            for (int i = 0; i < 100; i++) {
                int randNum = (int) (Math.random() * 10000); // Assigns random integers to the count
                fileWriter.write(String.valueOf(randNum)); // Convert a number to a string
                fileWriter.write(" ");
            }
            System.out.println("File saved successfully at " + outputfile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readData(String fileName, String dir) {
        File inputFile = new File(dir, fileName);
        // Declare and Initializing the number array list which will be populated by individual integers
        ArrayList<Integer> numbers = new ArrayList<>();

        try (Scanner scan = new Scanner(inputFile)) {
            while (scan.hasNextInt()) {
                numbers.add(scan.nextInt());
            }

            int[] arr = new int[numbers.size()];
            for (int i = 0; i < numbers.size(); i++) {
                arr[i] = numbers.get(i);
            }

            Arrays.sort(arr);
            System.out.println("Sorted numbers from file:");
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error occurred while reading the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
