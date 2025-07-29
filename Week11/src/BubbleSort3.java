import java.util.Arrays;

public class BubbleSort3 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 100, 90, 76, 45};
        bubbleSortThree(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSortThree(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }
    }
}
