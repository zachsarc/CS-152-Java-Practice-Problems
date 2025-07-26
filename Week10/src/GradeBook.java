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