import java.util.Arrays;

public class MergeSort7 {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 3, 6};
        System.out.println("Original Array: ");
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array: ");
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int s, int e) {
        if (s >= e) {
            return;
        }

        int m = (s + e) / 2;

        mergeSort(arr, s, m);
        mergeSort(arr, m + 1, e);
        merge(arr, s, m, e);
    }

    private static void merge(int[] arr, int s, int m, int e) {
        int n1 = m - s + 1;
        int n2 = e - m;

        int[] lh = new int[n1];
        int[] rh = new int[n2];

        for (int i = 0; i < n1; i++) {
            lh[i] = arr[s + i];
        }
        for (int j = 0; j < n2; j++) {
            rh[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0, k = s;

        while (i < n1 && j < n2) {
            if (lh[i] < rh[j]) {
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
