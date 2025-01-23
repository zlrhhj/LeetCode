import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ']') {
                List<Character> encoded_String = new ArrayList<>();
                while(stack.peek() != '[') {
                    encoded_String.add( stack.pop() );
                }
                stack.pop();
                int base = 1;
                int k = 0;
                while(!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    k += (stack.pop() - '0') * base;
                    base *= 10;
                }
                while(k > 0) {
                    for(int j = encoded_String.size() - 1; j >= 0; j--) {
                        stack.push(encoded_String.get(j));
                    }
                    k--;
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < stack.size(); i++) {
            result.append(stack.get(i));
        }
        return  result.toString();
    }
}
