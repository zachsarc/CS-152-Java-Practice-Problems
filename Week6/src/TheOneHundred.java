import java.util.Scanner;

/**
(ArrayIndexOutOfBoundsException) Write a program that meets the
 following requirements:
 ■ ■ Creates an array with 100 randomly chosen integers.
 ■ ■ Prompts the user to enter the index of the array, then displays the
 corresponding element value. If the specified index is out of bounds, display the
 message "Out of Bounds".
 */

public class TheOneHundred {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = createArray();

        do {
            System.out.print("What is the index of the integer you would like to find? ");
            int userIndex = sc.nextInt();
            if (userIndex < 0) {
                System.out.println("Please enter a positive integer from 0-100, please try again");
                continue;
            }

        try {
            int result = printElementAtIndex(array, userIndex);
            System.out.println("The value at index " + userIndex + " is: " + result);
            break; // Exit loop if successful
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index Out of Bounds");
        }
    } while (true);

    sc.close();

}

    public static int[] createArray() {
        int size = 100;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 101);
        }
        return arr;
    }

    public static int printElementAtIndex(int[] arr, int index) throws ArrayIndexOutOfBoundsException {
            return arr[index];
    }
}
