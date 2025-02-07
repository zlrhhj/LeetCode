import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int result =  num2 / num1 ;
                stack.add(result);
            } else if(tokens[i].equals("*")) {
                int result = stack.pop() * stack.pop();
                stack.add(result);
            } else if(tokens[i].equals("+")) {
                int result = stack.pop() + stack.pop();
                stack.add(result);
            } else if(tokens[i].equals("-")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int result = num2 - num1;
                stack.add(result);
            } else {
                stack.add(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
