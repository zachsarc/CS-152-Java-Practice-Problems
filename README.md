# Zach L Weekly-Practice

## CS-152

> A Repo' for all of my practice problems that is currently ongoing
  - [Back to main repo](https://github.com/zachsarc/CS-152_Java2/blob/main/README.md)
  - Week 0: Review of Java 1
  - Week 1: Big O Notation / Time & Space Complexities
  - Week 2: Single & Multi-Dimensional Arrays
  - Week 3: Recursion

***

### Week 0: Review of Java 1

***

### Week 1 Practice: Big O Notation / Time & Space Complexities
None
***
### Week 2 Practice: Single & Multi-Dimensional Arrays

## Grade Sheet
```java
import java.util.Scanner;

public class Week2GradesX {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int numOfStudents = sc.nextInt();
        int best = 100;

        if (numOfStudents <= 0) {
            System.out.println("Enter a positive integer silly, exiting...");
            System.exit(0);
        }

        int[] studentScores = new int[numOfStudents];
        System.out.println("Enter " + numOfStudents + " scores:");
        for (int z = 0; z < numOfStudents; z++) {
            studentScores[z] = sc.nextInt();
            if (studentScores[z] < 0) {
                System.out.println("Please enter a score higher than 0, exiting...");
                System.exit(0);
            }
        }

        int counter = 0;
            for (int j = 0; j < studentScores.length; j++)
                if (studentScores[j] >= (best - 10)) {
                System.out.println("Student " + counter + " score is: " + studentScores[j] + " and grade is: A");
                counter++;
            } else if (studentScores[j] >= (best - 20)) {
                    System.out.println("Student " + counter + " score is: " + studentScores[j] + " and grade is: B");
                    counter++;
                } else if (studentScores[j] >= (best - 30)) {
                    System.out.println("Student " + counter + " score is: " + studentScores[j] + " and grade is: C");
                    counter++;
                } else if (studentScores[j] >= (best - 40)) {
                    System.out.println("Student " + counter + " score is: " + studentScores[j] + " and grade is: D");
                    counter++;
                } else {
                    System.out.println("Student " + counter + " score is: " + studentScores[j] + " and grade is: F");
                    counter++;
                }
    }
}
```
***

## Multi-Dimensional Array Sums
```java
import java.util.Arrays;
import java.util.Scanner;

public class Week2MultiDimensionalArraySums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] matrix = new double[3][4]; // Create new matrix[][] array with size of col:3 row:4

        System.out.print("Enter a 3x4 Matrix Row by Row: ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("Enter row %d (4 numbers seperated by spaces): ", i + 1); // prompts the user to enter row 0
            for (int j = 0; j < matrix[i].length; j++) {
                if (!sc.hasNextDouble()) {
                    System.out.println("Decimal not entered, exiting..."); // Handles the non-decimal case
                    return;
                }
                matrix[i][j] = sc.nextDouble(); // Captures each value seperated from spaces
            }

            // Displays matrix to confirm input
            System.out.println("\nThe matrix you entered is:");
                for (double[] row : matrix) { // Enhanced for loop
                    System.out.println(Arrays.toString(row));
                }
            }
        // Call to sumColumn() method with parameters of the "Matrix Array" with a column start index of 0
        double sumOfColumn = sumColumn(matrix, 0);

        // Display the sums using traditional for loop formatting them correctly
        for (int col = 0; col < matrix[0].length; col++) {
            double columnSum = sumColumn(matrix, col);
            System.out.printf("Sum of colum %d is: %.2f%n", col, columnSum);
        }
    }

    public static double sumColumn(double[][] m, int columnIndex) {
        double sum = 0;
        for (int i = 0; i <m.length; i++) {
            sum += m[i][columnIndex];
        }
        return sum;
    }
}

```
***

## Week 3: BigInteger Factorials Using Recursion

## BigInteger Factorials Using Recursion
```java
/* INSTRUCTION
(Factorial) Using the BigInteger class introduced in Section 10.9, you can
find the factorial for a large number (e.g., 100!). Implement the factorial
method using recursion. Write a program that prompts the user to enter an inte-
ger and displays its factorial.

This program demonstrates core principles of recursion while maintaining efficiency with extra large numbers!
 */

import java.math.BigInteger;
import java.util.Scanner;
public class Week3BigIntegerRecursion {
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
```
***

## Computing GCD (a, b) Using Recursion
```java
/** INSTRUCTIONS:
 * Program to find the Greatest Common Divisor (GCD) using recursion.
 *
 * The GCD(m,n) is defined recursively as follows:
 * If m % n is 0, gcd(m, n) is n
 * Otherwise, gcd(m, n) is gcd(n, m % n)
 *
 * Write a recursive method to find the GCD. Write a test program that prompts the
 user to enter two integers and displays their GCD.
 *
 * This program prompts the user to enter two integers and displays their GCD.
 */
import java.util.Scanner;
import java.util.InputMismatchException;
public class Week3FindingGCD {
    public static void main(String[] args) {
        // Try with resources for the autoclose feature
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter number 1 (a): ");
            int numOne;
            try {
                numOne = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid Integer, exiting...");
                return;
            }
            System.out.println("Enter number 2 (b): ");
            int numTwo;
            try {
                numTwo = sc.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Invalid Integer, exiting...");
                return;
            }

            // Handles the non-positive integers
            if (numOne <= 0 || numTwo <= 0) {
                System.out.println("Please enter positive integers only");
                return;
            }
            System.out.println("Your GCD(a,b) is : " + getGCD(numOne, numTwo));
        }
    }

        public static int getGCD ( int a, int b){
            if (a % b == 0) { // Base case
                return b;
            }
            return getGCD(b, a % b); // Example of tail recursion
        }
    }
```

***

## Reversal of User Input Using Recursion
```java
/** INSTRUCTIONS
(Print the characters in a string reversely) Write a recursive method that dis-
plays a string reversely on the console using the following header:
public static void reverseDisplay(String value)
        For example, reverseDisplay("abcd") displays dcba. Write a test program
that prompts the user to enter a string and displays its reversal.
*/
import java.util.Scanner;
public class Week3TurnaroundUsingRecursion {
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
```
