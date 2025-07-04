/* INSTRUCTION
(Factorial) Using the BigInteger class introduced in Section 10.9, you can
find the factorial for a large number (e.g., 100!). Implement the factorial
method using recursion. Write a program that prompts the user to enter an inte-
ger and displays its factorial.

This program demonstrates core principles of recursion while maintaining efficiency with extra large numbers!
 */

import java.math.BigInteger;
import java.util.Scanner;
public class Week4BigIntegerRecursion {
    public static void main (String[] args) {
        // Create new Scanner and BigInteger Objects
        Scanner sc = new Scanner(System.in);
        BigInteger bigInt1 = null;

        // Prompt user to enter valid integer
        System.out.println("Please enter your Integer: ");

        try {
            bigInt1 = new BigInteger(sc.nextLine());
        } catch (NumberFormatException e) {
            // Practice using "e" for debug
            System.out.println("Error Message: " + e.getMessage());
            System.out.println("Please enter a valid integer, exiting");
            System.exit(0);
        }
        System.out.println(bigInt1 + "! = " + bigIntFactorial(bigInt1));
    }

    // Method to work with getting a Factorial number of a BigInteger accordingly
    public static BigInteger bigIntFactorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) { // Base case
            return BigInteger.ONE;
        } else {
            return n.multiply(bigIntFactorial(n.subtract(BigInteger.ONE))); // Recursive case
        }
    }
}
