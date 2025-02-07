import java.util.Stack;

public class MinStack {
    private Stack< int[] > stack;
    public MinStack() {
        stack = new Stack<>();
    }
    public void add(int val) {
        if(stack.isEmpty()) {
            stack.add(new int[] {val, val});
        } else {
            stack.add(new int[] {val, Math.min(val, stack.peek()[1])});
        }
    }
    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
