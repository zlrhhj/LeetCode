import java.util.Stack;

public class ValidParenthesisString {
    //Attempt #1 using stack
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
    //attempt #2
    public boolean checkValidStringII(String s) {
        int n = s.length();
        int openCount = 0;
        int closeCount = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '*') {
                openCount++;
            } else if(s.charAt(i) == ')') {
                openCount--;
            }
            if(openCount < 0) return false;
        }
        for(int i = n - 1; i >= 0; i--) {
            if(s.charAt(i) == ')' || s.charAt(i) == '*') {
                closeCount++;
            } else if(s.charAt(i) == '(') {
                closeCount--;
            }
            if(closeCount < 0) return false;
        }
        return true;
    }

}
