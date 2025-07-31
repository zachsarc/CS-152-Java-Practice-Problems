import java.util.Arrays;

public class MergeSort5 {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 3, 6};
        System.out.println("Original Array: ");
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array: ");
        System.out.println(Arrays.toString(arr));
    }
    private static void mergeSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int mid = (startIndex + endIndex) / 2;

        mergeSort(arr, startIndex, mid);
        mergeSort(arr, mid + 1, endIndex);
        merge(arr, startIndex, mid, endIndex);
    }
    private static void merge(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] lh = new int[n1];
        int[] rh = new int[n2];

        for (int i = 0; i < n1; i++) {
            lh[i] = arr[start + i];
        }
        for (int j = 0; j < n2; j++) {
            rh[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = start;

        while (i < n1 && j < n2) {
            if (lh[i] <= rh[j]) {
                arr[k] = lh[i];
                i++;
            } else {
                arr[k] = rh[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = lh[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rh[j];
            j++;
            k++;
        }
    }
}
