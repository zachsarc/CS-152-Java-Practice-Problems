import java.util.Stack;

public class DeleteMiddleOfStack {
    public static void main(String[] args) {
        Stack<Integer> oddStack = new Stack<>();
        Stack<Integer> evenStack = new Stack<>();
        System.out.println("------------Odd Stack Test------------");
        oddStack.push(1);
        oddStack.push(2);
        oddStack.push(3);
        oddStack.push(4);
        oddStack.push(5);
        System.out.println(oddStack + " - Original Stack");
        System.out.println(removeMiddleElement(oddStack) + " - Modified Stack");
        System.out.println("--------------------------------------");
        System.out.println();
        System.out.println("------------Even Stack Test------------");
        evenStack.push(1);
        evenStack.push(2);
        evenStack.push(3);
        evenStack.push(4);
        evenStack.push(5);
        evenStack.push(6);
        System.out.println(evenStack + " - Original Stack");
        System.out.println(removeMiddleElement(evenStack) + " - Modified Stack");
        System.out.println("--------------------------------------");


    }

    public static Stack<Integer> removeMiddleElement(Stack<Integer> s) {
        if(s.isEmpty()) {
            return null;
        }
            Stack<Integer> tempStack = new Stack<>();
            int size = s.size();
            int middleIndex = (size % 2 == 0) ? (size / 2 - 1) : (size / 2);

            for (int i = 0; i < middleIndex; i++) {
                tempStack.push(s.pop());
            }
            s.pop();

            while (!tempStack.isEmpty()) {
                s.push(tempStack.pop());
            }
            return s;
        }
    }
