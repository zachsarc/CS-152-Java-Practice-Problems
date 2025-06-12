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
