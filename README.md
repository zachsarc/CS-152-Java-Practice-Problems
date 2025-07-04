# Zach L Weekly-Practice
## CS-152

> A Repo' for all of my practice problems that is currently ongoing
  - [Back to main repo](https://github.com/zachsarc/CS-152_Java2/blob/main/README.md)
  - [Week 1](#Week-1): Review of Java 1
  - [Week 2](#Week-2): Big O Notation / Time & Space Complexities
  - [Week 3](#Week-3): Single & Multi-Dimensional Arrays
  - [Week 4](#Week-4): Recursion
  - [Week 5](#Week-5): Object-Oriented Thinking (OOP)
  - [Week 6](#Week-6): Exception Handling & File IO

***

## Week-1 
### <ins>***Review of Java 1***</ins>
NONE

***

## Week-2
### <ins>***Big O Notation / Time & Space Complexities***</isn>
NONE
***
## Week-3
### <ins>***Single & Multi-Dimensional Arrays***</ins>

## Grade Sheet
```java
import java.util.Scanner;

public class Week3GradesX {
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

public class Week3MultiDimensionalArraySums {
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

## Week-4
### <ins>***BigInteger Factorials Using Recursion***</ins>

### BigInteger Factorials Using Recursion
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
public class Week4FindingGCD {
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
```
***

## Week-5
### <ins>***Object Oriented Thinking (OOP)***</ins>

### The MyInteger Class

```java
public class MyInteger {
    public int value;

    // Constructor
    public MyInteger(int value) {
        this.value = value;
    }

    // Getter
    public int getMyInteger() {
        return value;
    }

    // Instance methods
    public boolean isEven() {
        return value % 2 == 0;
    }

    public boolean isOdd() {
        return value % 2 == 1;
    }

    public boolean isPrime() {
        if (value <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Static methods
    static boolean isEven(int n) {
        return n % 2 == 0;
    }

    static boolean isOdd(int n) {
        return n % 2 == 1;
    }

    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Static overloaded methods reusing same logic to keep code "DRY"
    public static boolean isEven(MyInteger myInt) {
        return isEven(myInt.getMyInteger());
    }

    static boolean isOdd(MyInteger myInt) {
        return isOdd(myInt.getMyInteger());
    }

    static boolean isPrime(MyInteger myInt) {
        return isPrime(myInt.getMyInteger());
    }

    // Instance Method for equals
    public boolean equals(int x) {
        return this.value == x;
    }

    // Overloaded method for equals
    public boolean equals(MyInteger myInt) {
        return this.value == myInt.getMyInteger();
    }

    // Static parseInt method for an array of chars with exception throw for whoever is calling the method
    public static int parseInt(char[] y) throws NumberFormatException {
        String str = String.valueOf(y);
        return Integer.parseInt(str);
    }

    // Static parseInt method for a String with exception throw for whoever is calling the method
    public static int parseInt(String s) throws NumberFormatException{
        return Integer.parseInt(s);
    }
}
```
### MyInteger Client (Tests for MyInteger)

```java
public class Client {
    public static void main(String[] args) {

        // Instance methods
        MyInteger testInt = new MyInteger(2);
        boolean testIntEven = testInt.isEven();
        System.out.println(testIntEven);
        boolean testIntOdd = testInt.isOdd();
        System.out.println(testIntOdd);
        boolean testIntPrime = testInt.isPrime();
        System.out.println(testIntPrime);

        // Static method tests
        System.out.println(MyInteger.isEven(4));
        System.out.println(MyInteger.isOdd(4));
        System.out.println(MyInteger.isPrime(4));

        // Static overloaded method tests
        MyInteger myNum = new MyInteger(15);
        System.out.println(MyInteger.isEven(myNum));
        System.out.println(MyInteger.isOdd(myNum));
        System.out.println(MyInteger.isPrime(myNum));

        // Instance method test for equals
        MyInteger equalInt = new MyInteger(4);
        System.out.println(equalInt.equals(4));

        // Overloaded method test for equals
        MyInteger ovrEqualInt = new MyInteger(10);
        System.out.println(ovrEqualInt.equals(testInt));

        // Test for static parseInt(char[] y) method with correct error handling
        try {
            char[] chars = new char[]{'2', '5', '2', '4'};
            int resultParsedChar = MyInteger.parseInt(chars);
            System.out.println("Parsed int on char result: " + resultParsedChar);

            // Test for static parseInt(String s) method with correct error handling
            String str = "16534234";
            int resultParsedString = MyInteger.parseInt(str);
            System.out.println("Parsed int on string result: " + resultParsedString);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input, Please use numeric characters");
        }
    }
}

```
### Directory Database Person.class (1)
```java
import java.util.Arrays;

import static java.lang.String.format;

/**
(The Person, Student, Employee, Faculty, and Staff classes) Design a class
named Person and its two subclasses named Student and Employee. Make
Faculty and Staff subclasses of Employee. A person has a name, address,
 phone number, and e-mail address. A student has a class status (freshman, sophomore, junior, or senior). Define the status as a constant. An employee has an
office, salary, and date hired. Use the MyDate class defined in Programming
        Exercise 10.14 to create an object for date hired. A faculty member has office
hours and a rank. A staff member has a title. Override the toString method in
each class to display the class name and the person’s name.
Draw the UML diagram for the classes and implement them. Write a test program
that creates a Person, Student, Employee, Faculty, and Staff, and invokes
their toString() methods.
*/

public class Person {
    private String name;
    private String address;
    private String phone;
    private String email;

    public Person(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    // Setters for validation (Not currently used but can be used with user input)
    @SuppressWarnings("unused")
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }

    @SuppressWarnings("unused")
    public void setAddress() {
        if (address != null && !name.trim().isEmpty()) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
    }

    @SuppressWarnings("unused")
    public void setPhone(String phone) {
        // Validation for number formatting
        if (phone != null && phone.matches("\\d{3}-\\d{3}-\\d{4}")) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Phone cannot be null and must be in the format: xxx-xxx-xxxx");
        }
    }

    @SuppressWarnings("unused")
    public void setEmail(String email) {
        if (email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email format invalid");
        }
    }

    @Override
    public String toString() {
        return String.format("Person[name=%s, address=%s, phone=%s, email=%s]", name, address, phone, email);
    }


    public static void main(String[] args) {
        Person person = new Person("Alice", "123 Berry Ln", "123-456-7890", "123yoohoo@gmail.com");
        Student student = new Student("Zach Lariccia", "123 Berry Ln", "123-456-7890", "123yoohoo@gmail.com", Student.Status.JUNIOR);
        Employee employee = new Employee("Chris Lariccia", "123 Berry Ln", "123-456-7890", "124yoohoo@gmail.com", "Rescue 1 Pest Control", 65000, System.currentTimeMillis() - 172800000L);
        Faculty faculty = new Faculty("Chris Lariccia", "123 Berry Ln", "123-456-7890", "124yoohoo@gmail.com", "Rescue 1 Pest Control", 100000000, System.currentTimeMillis() - 172800000L, 5400, "Top");
        Staff staff = new Staff("Zach Lariccia", "123 Berry Ln", "123-456-7890", "124yoohoo@gmail.com", "Rescue 1 Pest Control", 100000000, System.currentTimeMillis() - 172800000L, "CFO");

        // Simplified output using all information
        System.out.println("---------------Person---------------");
        System.out.println(person.toString());
        System.out.println();
        System.out.println("---------------Student---------------");
        System.out.println("-----------Student Statuses----------");
        System.out.println(Arrays.toString(Student.getAllStatuses()));
        System.out.println(student.toString());
        System.out.println();
        System.out.println("---------------Employee---------------");
        System.out.println(employee.toString());
        System.out.println();
        System.out.println("---------------Faculty---------------");
        System.out.println(faculty.toString());
        System.out.println();
        System.out.println("---------------Staff---------------");
        System.out.println(staff.toString());
        System.out.println();



            /* Manually Outputting with getters (Not used but can be for user input)
            System.out.println("---------------Person---------------");
            System.out.println("Name: " + person.getName());
            System.out.println("Address: " + person.getAddress());
            System.out.println("Phone: " + person.getPhone());
            System.out.println("Email: " + person.getEmail());

            System.out.println();
            System.out.println("---------------Student---------------");
            System.out.println("Name: " + student.getName());
            System.out.println("Address: " + student.getAddress());
            System.out.println("Phone: " + student.getPhone());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Status: " + student.getStatus());

            System.out.println();
            System.out.println("---------------Employee---------------");
            System.out.println("Name: " + employee.getName());
            System.out.println("Address: " + employee.getAddress());
            System.out.println("Phone: " + employee.getPhone());
            System.out.println("Email: " + employee.getEmail());
            System.out.println("Office: " + employee.getOffice());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("Hire Time (in milliseconds)" + employee.getDateHired());

            System.out.println();
            System.out.println("---------------Faculty---------------");
            System.out.println("Name: " + faculty.getName());
            System.out.println("Address: " + faculty.getAddress());
            System.out.println("Phone: " + faculty.getPhone());
            System.out.println("Email: " + faculty.getEmail());
            System.out.println("Office: " + faculty.getOffice());
            System.out.println("Salary: " + faculty.getSalary());
            System.out.println("Hire Date: " + faculty.getDateHired());
            System.out.println("Office Hours: " + faculty.getOfficeHours());
            System.out.println("Rank: " + faculty.getRank());

            System.out.println();
            System.out.println("---------------Staff---------------");
            System.out.println("Name: " + staff.getName());
            System.out.println("Address: " + staff.getAddress());
            System.out.println("Phone: " + staff.getPhone());
            System.out.println("Email: " + staff.getEmail());
            System.out.println("Office: " + staff.getOffice());
            System.out.println("Salary: " + staff.getSalary());
            System.out.println("Hire Date: " + staff.getDateHired());
            */
    }
}
```
### Directory Database Employee.class (2)
```java
public class Employee extends Person {
    private String office;
    private Double salary;
    private MyDate dateHired;

    public Employee(String name, String address, String phone, String email, String office, double salary, long hireTimeInMillis) {
        super(name, address, phone, email);
        this.office = office;
        this.salary = salary;
        this.dateHired = new MyDate(hireTimeInMillis);
    }

    // Getters
    public MyDate getDateHired() {
        return dateHired;
    }

    public String getOffice() {
        return office;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString () {
        return String.format("Employee[%s, office=%s, salary=%.2f, dateHired=%s]", super.toString(), office, salary, dateHired.toString());
    }
}
```
### Directory Database Student.class (3)
```java
public class Student extends Person {
    public enum Status {
        FRESHMAN,
        SOPHOMORE,
        JUNIOR,
        SENIOR
    }

    private Status status;

    public Student (String name, String address, String phone, String email, Status status) {
        super(name, address, phone, email);
            this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static Status[] getAllStatuses() {
        return Status.values();
    }

    @Override
    public String toString () {
        return String.format("Student[%s, status=%s]", super.toString(), status);
    }
}
```
### Directory Database MyDate.class (4)
```java
import java.util.Calendar;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(long elapsedTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(elapsedTime);
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH);
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    // Getters
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }
}
```
### Directory Database Faculty.class (5)
```java
public class Faculty extends Employee {
    private int officeHours;
    private String rank;

    public Faculty(String name, String address, String phone, String email, String office, double salary, long hireTimeInMillis, int officeHours, String rank) {
        super(name, address, phone, email, office, salary, hireTimeInMillis);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    public int getOfficeHours() {
        return officeHours;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString () {
        return String.format("Faculty[%s, officeHours=%s, rank=%s]", super.toString(), officeHours, rank);
    }
}
```
### Directory Database Staff.class (6)
```java
public class Staff extends Employee {
    private String title;

    public Staff(String name, String address, String phone, String email, String office, double salary, long hireTimeInMillis, String title) {
        super(name, address, phone, email, office, salary, hireTimeInMillis);
        this.title = title;
        }

        public String getTitle() {
        return title;
        }

    @Override
    public String toString () {
        return String.format("Staff[%s, title=%s]", super.toString(), title);
    }
}
```
***
## Week-6
### <ins>***Exception Handling & Errors & FileIO***</isn>
### TheOneHundred (Binary Decimal Converter)
```java
/**
 * A program to convert a binary string to decimal value with proper exception handling
 */

import java.util.Scanner;

public class BinaryStringConverter {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter the String you would like to convert: ");
            String userInput = sc.nextLine();

            try {
                double result = thisToThat(userInput);
                System.out.println("Your converted value is: " + result);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Not a binary number");
            }
        } while (true);

        sc.close();

    }

    public static double thisToThat (String inp) throws NumberFormatException{
        for (char c: inp.toCharArray()) {
            if (c != '0' && c != '1') {
                throw new NumberFormatException();
            }
        }
        return Double.parseDouble(inp);
    }
}
```
### TheOneHundred Custom Exception
```java
public class BinaryFormatException extends Exception {
    public BinaryFormatException(String message) {
        super(message);
    }
}
```
### TheOneHundred with Custom Exception
```java
/**
 * A program to convert a binary string to decimal value with custom exception handling
 */
import java.util.Scanner;

public class BinaryStringConverterWithCustomException {
        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);

            do {
                System.out.println("Enter the String you would like to convert: ");
                String userInput = sc.nextLine();

                try {
                    double result = thisToThat(userInput);
                    System.out.println("Your converted value is: " + result);
                    break;
                } catch (BinaryFormatException e) {
                    System.out.println("Not a binary number");
                }
            } while (true);

            sc.close();
        }

        public static double thisToThat (String inp) throws BinaryFormatException{
            for (char c: inp.toCharArray()) {
                if (c != '0' && c != '1') {
                    throw new BinaryFormatException("Not a binary number");
                }
            }
            return Double.parseDouble(inp);
        }
    }
```
### File Analyzer using File IO
```java
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
```
### Writing and Reading Integer Data using File I/O
```java
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
```
***
