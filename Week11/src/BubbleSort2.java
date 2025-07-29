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
