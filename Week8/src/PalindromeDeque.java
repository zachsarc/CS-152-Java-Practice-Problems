import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeDeque {
    public static void main(String[] args) {
        System.out.println("Word 1: racecar " + isPalindrome("racecar"));
        System.out.println("Word 2: car " + isPalindrome("car"));
    }

    public static String isPalindrome(String word) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : word.toCharArray()) {
            dq.addLast(c);
        }
        while (dq.size() > 1) {
            char f = dq.removeFirst();
            char l = dq.removeLast();
            if (f != l) {
                return "not a palindrome";
            }
        }
        return "is a palindrome";
    }
}
