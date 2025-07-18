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
