 import java.util.Stack;

    public class ReversedStringUsingStack {
        public static void main(String[] args) {
            System.out.println(reverseString("hello"));
        }

        public static String reverseString(String input) {
            Stack<Character> stack = new Stack<>();
            char[] charArray = input.toCharArray();
            String reversed = "";
            for (char c : charArray) {
                stack.push(c);
                System.out.println("Stack being built: " + stack);
            }
            while (!stack.isEmpty()) {
                char r = stack.pop();
                reversed += r;
            }
            return reversed;
        }
    }