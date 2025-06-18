/**
(Print the characters in a string reversely) Write a recursive method that dis-
plays a string reversely on the console using the following header:
public static void reverseDisplay(String value)
        For example, reverseDisplay("abcd") displays dcba. Write a test program
that prompts the user to enter a string and displays its reversal.
*/
import java.util.Scanner;
public class Week4TurnaroundUsingRecursion {
    public static void main (String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter word's to see the reverse: ");
            System.out.println();
            String userValue = sc.nextLine();

            // Handles non-strings !(A-Z)
            if (!userValue.matches("[a-zA-Z\\d ]+")) {
                System.out.println("Please enter valid words, Exiting...");
                System.exit(0);
            }

            reverseDisplay(userValue);
        }
    }

    public static void reverseDisplay (String s) {
        if (s == null || s.length() <= 1) { // Base case
            System.out.println(s);
            return;
        }

        System.out.print(s.charAt(s.length() - 1)); // Prints last indexed Char starting with last

        reverseDisplay(s.substring(0, s.length() - 1)); // Recursive call which extracts substrings of indexes 0-4 because the last one is already printed (s.length() - 1)
    }
}
