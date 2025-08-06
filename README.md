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
  - [Week 7](#Week-7): JavaFX GUI (Seperate Repo.)
  - [Week 8 & 9](#Week-8_and_9): Lists, Stacks, Queues, and Priority Queues
  - [Week 10](#Week-10): Sets and Maps
  - [Week 11](#Week-11): Sorting Algorithms

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
## Week-7
### <ins>***JavaFX GUI***</isn>
### Local MP3 Player w/ rate functionality please refer to [this repo.](https://github.com/zachsarc/LocalMP3Player)

***
## Week-8_and_9
### <ins>***Lists, Stacks, Queues, Priority Queues***</isn>
### FiveMillion
```java
/*
(Use iterators on linked lists) Write a test program that stores 5 million integers
in a linked list and test the time to traverse the list using an iterator vs. using
the get(index) method.
*/

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class FiveMillion {
    public static void main(String[] args) {
        //linkedGen(5000000);
        linkedGen(5000000);
    }

    public static void linkedGen(int size) {
        LinkedList<Integer> fiveMil = new LinkedList<>();
        Random randomNum = new Random();
        // Populate linked list
        for (int i = 0; i < size; i++) {
            int r = randomNum.nextInt(size); // Limited the random number for data size allocation purposes
            fiveMil.add(r);
        }
        // Begin process speed timer for iterator
        long startTimer = System.nanoTime();
        Iterator<Integer> it = fiveMil.iterator();
        while (it.hasNext()) {
            it.next();
        }
        long endTimer = System.nanoTime();
        long resultNs = endTimer - startTimer;
        long resultMs = resultNs / 1_000_000;

        // Print computed process speed and display it in ms
        System.out.println();
        System.out.println("Finished...");
        System.out.println("Iterator process time: " + resultMs + "ms");
        System.out.println("The current size of the linked list is " + fiveMil.size());
        System.out.println();


        // Method 2
        startTimer = System.nanoTime();
        for (int i = 0; i < fiveMil.size(); i++) {
            fiveMil.get(i);
        }
        endTimer = System.nanoTime();
        resultNs = endTimer - startTimer;
        resultMs = resultNs / 1_000_000;
        System.out.println("get(index) process time: " + resultMs + "ms");
        System.out.println("The current size of the linked list is " + fiveMil.size());
    }
}

/* Note
The whole purpose of this exercise is to show how inefficient indexing linked lists actually are;
while using the implemented iterator is superior for linked lists
 */
```
### First Non-Repeating using Queue
```java
import java.util.*;

// A program that prints the first occurrence of a non-repeating letter in string, if all characters repeat then '_' is printed

public class OccurenceQueue {
    public static void main (String[] args) {
        System.out.println(firstNonRepeating("abbccdd"));
    }

    public static char firstNonRepeating(String input) {
        Queue<Character> q = new LinkedList<>();
        Map<Character, Integer> m = new HashMap<>();
        char qIsEmpty = '_';
        for (char c: input.toCharArray()) {
            q.add(c);
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        while(!q.isEmpty() && m.get(q.peek()) > 1 ){
            q.poll();
        }
        if (q.isEmpty()) {
            return qIsEmpty;
        } else {
            return q.peek();
        }
    }
}
```
### Palindrome Chcker Using Deque
```java
import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeDeque {
    public static void main(String[] args) {
        System.out.println("Word 1: racecar " + isPalindrome("racecar"));
        System.out.println("Word 2: car " + isPalindrome("car"));
    }

    public static String isPalindrome(String word) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : word.toCharArray()) {
            dq.addLast(c);
        }
        while (dq.size() > 1) {
            char f = dq.removeFirst();
            char l = dq.removeLast();
            if (f != l) {
                return "not a palindrome";
            }
        }
        return "is a palindrome";
    }
}
```
### Reversed String using Stack
```java
 import java.util.Stack;

    public class ReversedStringUsingStack {
        public static void main(String[] args) {
            System.out.println(reverseString("hello"));
        }

        public static String reverseString(String input) {
            Stack<Character> stack = new Stack<>();
            char[] charArray = input.toCharArray();
            String reversed = "";
            for (char c : charArray) {
                stack.push(c);
                System.out.println("Stack being built: " + stack);
            }
            while (!stack.isEmpty()) {
                char r = stack.pop();
                reversed += r;
            }
            return reversed;
        }
    }
```
### Parenthesis Validator Using Stack
```java
import java.util.Stack;

public class ValidParUsingStack {
    public static void main(String[] args) {
        ValidParUsingStack test = new ValidParUsingStack();
        System.out.println(test.isValid("()[]{}"));
        System.out.println(test.isValid("([)]"));
        System.out.println(test.isValid("{[]}"));
        System.out.println(test.isValid("((())"));
    }

    public boolean isValid (String par) {
        Stack<Character> stack = new Stack<>();

            for (char c : par.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) return false;

                    char top = stack.pop();

                    if ((c == ')') && top != '(') return false;
                    if ((c == '}') && top != '{') return false;
                    if ((c == ']') && top != '[') return false;
                }
            }
            return stack.isEmpty();
    }
}
```
### Task Scheduler Using Priority Queue
```java
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TaskSchedulerPriorityQueue {
    public static void main(String[] args) {
        List<Task> lt = new ArrayList<>();
        Task task1 = new Task("Feed the dog", 1);
        Task task2 = new Task("Put away laundry", 3);
        Task task3 = new Task("Feed myself", 2);
        lt.add(task3);
        lt.add(task1);
        lt.add(task2);

        scheduleTasks(lt);

    }

    public static void scheduleTasks(List<Task> tasks) {
        PriorityQueue<Task> pq = new PriorityQueue<>();
        pq.addAll(tasks);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
```
### Task class, Extension of Task Scheduler
```java
// this class sets up for TaskSchedulerPriorityQueue.java
public class Task implements Comparable<Task>{
    private String name;
    private int priority;
    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }
    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return name + " (priority: " + priority + ")";
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }
}
```
***
### Student Sorter by GPA using Priority Queue and Custom Comparator
```java
import java.util.*;

public class SortStudentsGpaPriorityQueue {
    public static void main(String[] args) {
        List<Student> lt = new ArrayList<>();
        Student s2 = new Student("Lindsay", 0);
        Student s1 = new Student("Liam", 0);
        Student s3 = new Student("Zach", 0);
        Student s4 = new Student("Jocy", 0);

        // Using the setGpa() setter method to ensure robust exception handling
        s2.setGpa(3.70);
        s1.setGpa(3.67);
        s3.setGpa(4.0);
        s4.setGpa(4.0);

        lt.add(s1);
        lt.add(s2);
        lt.add(s3);
        lt.add(s4);

        processStudents(lt);
    }

    public static void processStudents(List<Student> students) {
        PriorityQueue<Student> pq = new PriorityQueue<>((a, b) -> Double.compare(b.getGpa(), a.getGpa()));
        pq.addAll(students);

        while (!pq.isEmpty()) {
            Student student = pq.poll();
            System.out.println(student.getName() + ": " + student.getGpa());
        }
    }
}
```
### Student Class extension for Student Sorter
```java
public class Student {
    private String name;
    private double gpa;
    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }
    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return name + " has a (" + gpa + ")";
    }

    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }
    }
}
```
***
### Remove Duplicates using List
```java
/* NOTE: Sorting with Comparator is not for practical reasons (i.e. not preserve the original order), however,
I wanted to try and implement it somehow into this code.
 */

import java.util.*;

public class ListDuplicates {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(6);
        list.add(4);
        list.add(3);
        System.out.println("The original list is " + removeDuplicates(list));
    }

    public static List<Integer> removeDuplicates(List<Integer> nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> alreadySeenSet = new HashSet<>();

        for (Integer n : nums) {
            list.add(n);
            alreadySeenSet.add(n);
        }
        System.out.println("The set with no duplicates is " + alreadySeenSet);
        list.sort(Comparator.naturalOrder());
        return list;
    }
}
```
***
### Browser History Simulator
```java
public class BrowserHistorySimulation {
    public static void main(String[] args) {
        BrowserMain b1 = new BrowserMain();
        b1.visit("https://www.google.com");
        b1.visit("https://www.formula1.com");
        b1.visit("https://www.ccsu.edu");
        b1.visit("https://www.f1tv.formula1.com");

        // Printing
        System.out.println("Current page is: " + b1.getCurrentPage());
        b1.back();
        System.out.println("One page back is: " + b1.getCurrentPage());
        b1.forward();
        System.out.println("One page forward is: " + b1.getCurrentPage());
        b1.back();
        b1.back();
        System.out.println("Two pages back is: " + b1.getCurrentPage());
        b1.back();
        System.out.println("One page back is: " + b1.getCurrentPage());
    }
}
```
### Browser Main Extension of Browser Simulation
```java
import java.util.ArrayDeque;

public class BrowserMain {
    ArrayDeque<String> backStack = new ArrayDeque<>();
    ArrayDeque<String> forwardStack = new ArrayDeque<>();
    String currentPage;

    public void visit(String url) {
        if (currentPage != null) {
            backStack.push(currentPage);
        }
        currentPage = url;
        forwardStack.clear();
    }

    public String back() {
        if (backStack.isEmpty()) {
            return currentPage;
        }
        forwardStack.push(currentPage);
        currentPage = backStack.pop();
        return currentPage;
    }

    public String forward() {
        if (forwardStack.isEmpty()) {
            return currentPage;
        }
        backStack.push(currentPage);
        currentPage = forwardStack.pop();
        return currentPage;
    }

    public String getCurrentPage() {
        return currentPage == null ? "You're not on a page" : currentPage;
    }
}
```
***
### ER-Triage Database
```java
// A program to simulate an Emergency Room Triage System

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ERTriageSystem {
    public static void main(String[] args) {
        Patient p1 = new Patient("Bob Kodiak", 3, 1);
        Patient p2 = new Patient("Don Kodiak", 1, 2);
        Patient p3 = new Patient("Patty Zimmerman", 2, 3);
        List<Patient> patients = new ArrayList<>();
        patients.add(p1);
        patients.add(p2);
        patients.add(p3);


        processPatients(patients);
    }

    public static void processPatients(List<Patient> patients) {
        PriorityQueue<Patient> pq = new PriorityQueue<>();

        System.out.println("--------------------Patient List--------------------");
        for (Patient p : patients) {
          pq.add(p);
          System.out.println("Patient Name: " + p.getName() + "    Severity: " + p.getSeverity() + "    Arrival Place: " + p.getArrivalOrder());
        }
        System.out.println("----------------------------------------------------");
        System.out.println();
            while (!pq.isEmpty()) {
                Patient currentPatient = pq.poll();
                System.out.println("Currently treating: " + currentPatient.getName() + " (Severity: " + currentPatient.getSeverity() + ", Arrival Order: " + currentPatient.getArrivalOrder() + ")");
            }
    }
}
```
### Patient Extension of ER-Triage Database
```java
public class Patient implements Comparable<Patient>{

    private String name;
    private int severity;
    private int arrivalOrder;

    public Patient(String name, int severity, int arrivalOrder) {
        this.name = name;
        this.severity = severity;
        this.arrivalOrder = arrivalOrder;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    public int getArrivalOrder() {
        return arrivalOrder;
    }

    @Override
    public int compareTo(Patient other) {
        int severityCmp = Integer.compare(this.severity, other.severity);
        return (severityCmp != 0) ? severityCmp : Integer.compare(this.arrivalOrder, other.arrivalOrder);
    }
}
```
***
### Sliding Window Max with Deque
```java
import java.util.*;

public class SlidingWindowMax{
    public static void main(String[] args) {
        int[] arr = new int[]{3, 3, 1, -2, 5, 2, 6, 8, 4, 10};
        System.out.println(Arrays.toString(arr));
        int windowSize = 3;
        System.out.println(slidingWindowMax(arr, windowSize));
    }

    public static List<Integer> slidingWindowMax(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
                while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                    dq.removeLast();
                }
            dq.addLast(i);

            if (dq.peekFirst() < i - k + 1) { // Finding the leftmost index in the current window
                dq.removeFirst();
            }

            if (i >= k - 1) { // Makes sure the window is full hence i = currentIndex and k - 1 is, the size of the window - 1 (i.e k=3, i=2 {0, 1, 2} so the first full window is 3-1= index 2
                result.add(nums[dq.peekFirst()]); //
            }
        }
        return result;
    }
}
```
***
### Deleting Middle Element using Stack
```java
import java.util.Stack;
public class DeleteMiddleOfStack {
    public static void main(String[] args) {
        Stack<Integer> oddStack = new Stack<>();
        Stack<Integer> evenStack = new Stack<>();
        System.out.println("------------Odd Stack Test------------");
        oddStack.push(1);
        oddStack.push(2);
        oddStack.push(3);
        oddStack.push(4);
        oddStack.push(5);
        System.out.println(oddStack + " - Original Stack");
        System.out.println(removeMiddleElement(oddStack) + " - Modified Stack");
        System.out.println("--------------------------------------");
        System.out.println();
        System.out.println("------------Even Stack Test------------");
        evenStack.push(1);
        evenStack.push(2);
        evenStack.push(3);
        evenStack.push(4);
        evenStack.push(5);
        evenStack.push(6);
        System.out.println(evenStack + " - Original Stack");
        System.out.println(removeMiddleElement(evenStack) + " - Modified Stack");
        System.out.println("--------------------------------------");


    }

    public static Stack<Integer> removeMiddleElement(Stack<Integer> s) {
        if(s.isEmpty()) {
            return null;
        }
            Stack<Integer> tempStack = new Stack<>();
            int size = s.size();
            int middleIndex = (size % 2 == 0) ? (size / 2 - 1) : (size / 2);

            for (int i = 0; i < middleIndex; i++) {
                tempStack.push(s.pop());
            }
            s.pop();

            while (!tempStack.isEmpty()) {
                s.push(tempStack.pop());
            }
            return s;
        }
    }
```
***
## Week-10
### <ins>***Sets & Maps***</isn>
### CountOccurrences
```java
import java.io.File;
import java.io.IOException;
import java.util.*;

public class CountOccurrencesFromFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the absolute directory the text file is in: ");
        String dir = sc.nextLine();
        countOccurrences(dir);
        sc.close();
    }

    public static void countOccurrences(String filePath) {
        Map<String, Integer> mp = new TreeMap<>();
        File userFile = new File(filePath);

        if (!userFile.exists()) {
            System.out.println("File not found at path: " + filePath);
            return;
        }

        try (Scanner fileScanner = new Scanner(userFile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] words = line.split("\\s+"); // split by 1+ spaces
                    for (String word : words) {
                        String key = word.toLowerCase();
                        if (!key.isEmpty()) {
                            if (!mp.containsKey(key)) {
                                mp.put(key, 1);
                            } else {
                                int value = mp.get(key);
                                value++;
                                mp.put(key, value);
                            }
                        }
                    }
                }
            }

            List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(mp.entrySet());
            sortedEntries.sort((e1, e2) -> {
                int valueCompare = e2.getValue().compareTo(e1.getValue());
                if (valueCompare == 0) {
                    return e1.getKey().compareTo(e2.getKey());
                }
                return valueCompare;
            });
            System.out.println("Word occurrences (most frequent first)");
            for (Map.Entry<String, Integer> entry : sortedEntries) {
                System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

    }
}
```
***
### SetMethods
```java
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetMethods {
    public static void main(String[] args) {

        // Append Element to HashSet
        HashSet<String> s = new HashSet<>();
        s.add("Green");
        s.add("Blue");
        s.add("Red");
        System.out.println("Base Set Includes Elements: " + s);

        // Iterating over HashSet
        System.out.println();
        Iterator<String> iterator = s.iterator();
        System.out.println("Iterating over elements we get: ");
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
        System.out.println();

        // Size of HashSet
        System.out.println("The current HashSet contains " + s.size() +  " elements");
        System.out.println();

        // Clear HashSet
        s.clear();
        System.out.println("The current HashSet has just been cleared...");
        System.out.println("The current HashSet contains " + s.size() +  " elements");
        System.out.println();

        // Check if HashSet is Empty
        if(s.isEmpty()) {
            System.out.println("Hashset is confirmed to be empty");
        } else {
            System.out.println("Hashset is confirmed to have elements at this time");
        }
        System.out.println();

        // Adding elements back to HashSet
        s.add("Green");
        s.add("Blue");
        s.add("Red");
        System.out.println("Set  'S' Includes Elements: " + s);
        System.out.println();

        // Cloning HashSet
        HashSet b = new HashSet<>();
        b = (HashSet)s.clone();
        System.out.println("Cloned HashSet b's elements are " + b);
        System.out.println();

        // Convert HashSet to Array
        String[] newArr = new String[b.size()];
        b.toArray(newArr);
        System.out.println("Set b converted to an Array: " + b);
        System.out.println();

        // Converting HashSet to TreeSet
        Set<String> sHashToTree = new TreeSet<>(s);
        System.out.println("Converted 's' set from HashSet to TreeSet, elements: " + s);
        System.out.println();

        // Creating a new TreeSet
        Set<String> cTree = new TreeSet<>();
        cTree.add("Violet");
        cTree.add("Aqua");
        cTree.add("Grey");
        cTree.add("Blue");
        System.out.println("Created a new 'c' TreeSet, elements: " + cTree);

        // Comparing 2 TreeSets
        if (sHashToTree.equals(cTree)) {
            System.out.println("Both the 's' and 'c' TreeSets are equal!");
        } else {
            System.out.println("'c' : " + cTree + "    |    " + "'s' : " + sHashToTree);
            System.out.println("Both the 's' and 'c' TreeSets are NOT equal!");
        }

        // Retaining elements from another set
        System.out.println();
        cTree.retainAll(sHashToTree);
        System.out.println("'c' set retained only the elements in 's' set");
        System.out.println("Updated 'c' TreeSet: " + cTree);

        // Displaying specs of each set after modification
        System.out.println();
        System.out.printf("Available Set: %-5s | # of Elements: %d%n", "s", 3);
        System.out.printf("Available Set: %-5s | # of Elements: %d%n", "c", 1);
        System.out.printf("Available Set: %-5s | # of Elements: %d%n", "b", 3);
        System.out.printf("Available Set: %-5s | # of Elements: %d%n", "s Tree", 3);
    }
}
```
***
### Advanced Grade book using Map<>
```java
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map;

public class GradeBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> mp = new HashMap<>();
        mp.put("Diana", 50);
        mp.put("Bella", 98);
        mp.put("Zach", 100);
        mp.put("Chris", 99);
        mp.put("Mike", 78);

        boolean continueProgram = true;
        while (continueProgram) {
            System.out.println("Are you a student or teacher? (Or type 'exit' to quit)");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("exit")) {
                continueProgram = false;
                continue;
            }

            if (choice.equalsIgnoreCase("student")) {
                System.out.println("Please enter your name (Case Sensitive): "); // Assuming the user is in the grade book;
                String input = sc.nextLine();
                searchGradeBook(input, mp);
            } else if (choice.equalsIgnoreCase("teacher")) {
                boolean teacherMenu = true;
                while (teacherMenu) {
                    System.out.println("Would you like to 'lookup' a students grade or 'add' a students grade? (Or type back to return to main menu)");
                    String choice2 = sc.nextLine();

                    if (choice2.equalsIgnoreCase("back")) {
                        teacherMenu = false;
                        continue;
                    }

                    if (choice2.equalsIgnoreCase("lookup")) {
                        System.out.println("Please enter the students name (Case Sensitive): ");
                        String studentsName = sc.nextLine();
                        searchGradeBook(studentsName, mp);
                    } else if (choice2.equalsIgnoreCase("add")) {
                        System.out.println("Please enter the students name: ");
                        String name = sc.nextLine();
                        System.out.println("Now please enter the grade to the corresponding student: ");
                        int grade = sc.nextInt();
                        sc.nextLine();
                        addToGradeBook(name, grade, mp);
                    } else {
                        System.out.println("Invalid option. Please try again");
                    }
                }
            } else {
                System.out.println("Invalid option. Please enter 'student' or 'teacher'");
            }
        }
        sc.close();
    }

    public static void searchGradeBook(String input, Map<String, Integer> mp) {
            if (mp.containsKey(input)) {
                int grade = mp.get(input);
                System.out.println(input + "'s grade: " + grade);
            } else {
                System.out.println("Student not found");
            }
    }

    public static void addToGradeBook(String k, int v, Map<String, Integer> mp) {
        Scanner scan = new Scanner(System.in);
        if (mp.containsKey(k)) {
            System.out.println("Student already in grade book");
            System.out.println();
            System.out.println("Did you want to update the grade?");
            String choice3 = scan.nextLine();
            if (choice3.equalsIgnoreCase("yes")) {
                mp.put(k, v);
                System.out.println(k + "'s grade has been updated with a new grade of " + v);
            } else if (choice3.equalsIgnoreCase("no")) {
                System.out.println("Ok!, exiting");
            } else {
                System.out.println("Please enter a valid input, yes or no");

            }

            return;
        }
        mp.put(k, v);
        Iterator<Map.Entry<String, Integer>> it = mp.entrySet().iterator();
        System.out.println("Your student, " + k + "'s grade is a " + v);
        System.out.println();
        System.out.println("The current gradebook is as follows: ");
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            System.out.println("Name: " + entry.getKey() + "    Grade: " + entry.getValue());
        }

    }
}
```
***
### Remove Redundant Words - Displayed in Lexicographical Order
```java
import java.util.*;

public class UniqueWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your sentence (or paragraph), where you want redundancies removed and frequency counted: ");
        String s = sc.nextLine();
        removeRedundant(s);
        System.out.println();
        frequencyCounter(s);
        sc.close();

    }

    public static void removeRedundant(String s) {
        Set<String> tree = new TreeSet<>();
        String[] myArr = s.split("[,\\.\\s!?:;]+");
        for (String word : myArr) {
            if (!word.isEmpty()) {
                tree.add(word.toLowerCase());
            }
        }
        Iterator<String> value = tree.iterator();
        System.out.println("Unique Words in lexicographical order: ");
        while (value.hasNext()) {
            System.out.println(value.next());
        }
    }

    public static void frequencyCounter (String s) {
        Map<String, Integer> tree = new TreeMap<>();
        String[] myArr = s.split("[,\\.\\s!?:;]+");
        for (String word : myArr) {
            String key = word.toLowerCase();
            if (!word.isEmpty()) {
                tree.put(word, tree.getOrDefault(key, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> sorted = new ArrayList<>(tree.entrySet());
        sorted.sort((c1, c2) -> {
            int valueCompare = c2.getValue().compareTo(c1.getValue());
            if (valueCompare == 0) {
                return c1.getKey().compareTo(c2.getKey());
            }
            return valueCompare;
        });
        System.out.println("Word occurrences");
        for (Map.Entry<String, Integer> entry : sorted) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}

// Test Phrase with redundant words: apple banana orange apple grape banana
```
***
## Week-11
### <ins>***Sorting and Algorithms***</isn>
### BubbleSort (x5)
```java
import java.util.Arrays;

public class BubbleSort2 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 100, 90, 76, 45};
        bubbleSortTwo(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSortTwo(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped on the inner array, then it is sorted break of out loop
            if (!swapped) {
                break;
            }
        }
    }
}
```
***
### Insertion Sort (x2)
```java
import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 100, 90, 76, 45};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void sort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Current element
            int j = i - 1; // Element before current element

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
```
***
###
```java
import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 100, 90, 76, 45};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void sort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Current element
            int j = i - 1; // Element before current element

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
```
***
### MergeSort (x10)
```java
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 3, 6};
        System.out.println("Original Array: ");
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array: ");
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) { // Base case: if the array has 1 or no elements, it's already sorted
            return;
        }
        int mid = (start + end) / 2;

        mergeSort(arr, start, mid); // Recursively sort the left half
        mergeSort(arr, mid + 1, end); // Recursively sort the right half
        merge(arr, start, mid, end); // Merge the two sorted halves
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1; // Size of the left half
        int n2 = end - mid; // Size of the right half

        int[] lh = new int[n1]; // temp array for the left half with size n1
        int[] rh = new int[n2]; // temp array for the right half with size n2

        // Copy the left half of arr into lh[]
        for (int i = 0; i < n1; i++) {
            lh[i] = arr[start + i];
        }

        // Copy the right half of arr into rh[]
        for (int j = 0; j < n2; j++) {
            rh[j] = arr[mid + 1 + j];
        }
        // Initialize pointers for lh[], rh[], and the main arr[]
        int i = 0, j = 0, k = start;

        // Merge the lh[] and rh[] arrays into arr[]
        while (i < n1 && j < n2) {
            if (lh[i] <= rh[j]) { // Take from the left half if smaller
                arr[k] = lh[i]; // Assign the smaller left-half element to arr[k] element at kth position
                i++; // Increment i for next comparison
            } else { // Take from right if smaller
                arr[k] = rh[j]; // Assign the smaller right-half element to arr[k] element at kth position
                j++; // Increment j for next comparison
            }
            k++; // increment to move to next position in result array
        }
        // Copy any remaining elements from lh[]
        while (i < n1) {
            arr[k] = lh[i];
            i++;
            k++;
        }
        // Copy any remaining elements from rh[]
        while (j < n2) {
            arr[k] = rh[j];
            j++;
            k++;
        }
    }
}
```
***
### QuickSort (x10)
```java
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 3, 6};
        System.out.println("Original Array: ");
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array: ");
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        int pivotIndex = partition(arr, lowIndex, highIndex);

        quickSort(arr, lowIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, highIndex);

    }

    private static int partition(int[] arr, int lowIndex, int highIndex) {
        int pivot = arr[highIndex];
        int i = lowIndex - 1;

        for (int j = lowIndex; j < highIndex; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, highIndex);

        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```
