import java.util.Arrays;

public class MergeSort3 {
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
        // calculating sizes for temp arrays
        int n1 = m - s + 1;
        int n2 = e - m;

        // creating temp arrays
        int[] lh = new int[n1];
        int[] rh = new int[n2];

        // copy array from original to temp left side ONLY
        for (int i = 0; i < n1; i++) {
            lh[i] = arr[s + i];
        }

        // copy array from original to temp right side ONLY
        for (int i = 0; i < n2; i++) {
            rh[i] = arr[m + 1 + i];
        }

        // create pointers
        int i = 0, j = 0, k = s;

        // while both i & j are within bounds
        while (i < n1 && j < n2) {
            // start comparing
            if (lh[i] <= rh[j]) {
                arr[k] = lh[i];
                i++;
            } else {
                arr[k] = rh[j];
                j++;
            }
            k++;
        }
        // process any remaining elements
        while (i < n1) {
            lh[i] = arr[k];
            i++;
        }
        while (j < n2) {
            rh[j] = arr[k];
            j++;
        }
    }
}
