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
