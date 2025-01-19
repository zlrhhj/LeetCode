import java.util.Stack;

public class StockSpanner {
    private Stack<int[]> stack = new Stack<>();
    public StockSpanner(){}
    //Attempt #1 stack;
    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        stack.add(new int[]{price, span});
        return span;
    }
}
