import java.util.*;

// A program that prints the first occurrence of a non-repeating letter in string, if all characters repeat then '_' is printed

public class OccurenceQueue {
    public static void main (String[] args) {
        System.out.println(firstNonRepeating("abbccdd"));
    }

    public static char firstNonRepeating(String input) {
        Queue<Character> q = new LinkedList<>();
        Map<Character, Integer> m = new HashMap<>();
        char qIsEmpty = '_';
        for (char c: input.toCharArray()) {
            q.add(c);
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        while(!q.isEmpty() && m.get(q.peek()) > 1 ){
            q.poll();
        }
        if (q.isEmpty()) {
            return qIsEmpty;
        } else {
            return q.peek();
        }
    }
}
