import java.util.Deque;
import java.util.ArrayDeque;
import static java.lang.System.out;

public class Stack {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(2);
        stack.push(1);
        stack.push(8);
        stack.push(3);
        out.println("Top of stack: " + stack.peek());
        out.println("Original stack: " + stack);
        out.println("popped: " + stack.pop());
        out.println("Top of stack: " + stack.peek());
        out.println("Updated stack: " + stack);
        out.println("popped: " + stack.pop());
        out.println("Updated stack: " + stack);
        out.println("popped: " + stack.pop());
        out.println("Updated stack: " + stack);
    }
}
