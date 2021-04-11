import java.util.Deque;
import java.util.ArrayDeque;

public class Stack {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(2);
        stack.push(1);
        stack.push(8);
        stack.push(3);
        System.out.println("Stack: " + stack);
        stack.pop();
        System.out.println("Stack: " + stack);
        stack.pop();
        System.out.println("Stack: " + stack);
    }
}
