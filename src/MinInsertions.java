import java.util.Stack;

public class MinInsertions {
    public int minInsertions(String s) {
        int minInsertions = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                if(!stack.isEmpty() && stack.peek() == ')') {
                    minInsertions++;
                    stack.pop();
                    stack.pop();
                }
                stack.add(c);
            } else {
                if(stack.isEmpty()) {
                    minInsertions++;
                    stack.add('(');
                } else {
                    if(stack.peek() == '(') {
                        stack.add(c);
                    } else {
                        stack.pop();
                        stack.pop();
                    }
                }
            }
        }
        while(!stack.isEmpty()) {
            if(stack.pop() == '(') {
                minInsertions += 2;
            } else {
                minInsertions++;
                stack.pop();
            }
        }
        return minInsertions;
    }
}
