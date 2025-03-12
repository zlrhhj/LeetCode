import java.util.Stack;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '*') {
                stack.add(c);
            } else if(c == ')') {
                int stars = 0;
                while(!stack.isEmpty() && stack.peek() == '*') {
                    stars++;
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    if(stars == 0) return false;
                    stars--;
                } else {
                    stack.pop();
                }
                while(stars > 0) {
                    stack.add('*');
                    stars--;
                }
            }
        }
        int stars = 0;
        while(!stack.isEmpty()) {
            if(stack.peek() == '*') {
                stars++;
                stack.pop();
            }
            else if(stack.peek() == '(') {
                if(stars > 0) {
                    stack.pop();
                    stars--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
