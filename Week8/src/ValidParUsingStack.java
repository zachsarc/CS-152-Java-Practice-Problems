import java.util.Stack;

public class ValidParUsingStack {
    public static void main(String[] args) {
        ValidParUsingStack test = new ValidParUsingStack();
        System.out.println(test.isValid("()[]{}"));
        System.out.println(test.isValid("([)]"));
        System.out.println(test.isValid("{[]}"));
        System.out.println(test.isValid("((())"));
    }

    public boolean isValid (String par) {
        Stack<Character> stack = new Stack<>();

            for (char c : par.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) return false;

                    char top = stack.pop();

                    if ((c == ')') && top != '(') return false;
                    if ((c == '}') && top != '{') return false;
                    if ((c == ']') && top != '[') return false;
                }
            }
            return stack.isEmpty();
    }
}
