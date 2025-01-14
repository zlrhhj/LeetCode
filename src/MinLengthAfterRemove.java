import java.util.Stack;

public class MinLengthAfterRemove {
    //Attempt #1: using stack;
    public int minLength(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!stack.isEmpty()) {
                if((stack.peek() == 'A' && c == 'B') || (stack.peek() == 'C' && c == 'D')) {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            } else {
                stack.add(c);
            }
        }
        return stack.size();
    }
    //Attempt #2:
    public int minLength2(String s) {
        int w = 0, r = 0;
        char[] arr = s.toCharArray();
        for(int i = 1; i < s.length(); i++) {
            r = i;
            if((arr[w] == 'A' && arr[r] == 'B') || (arr[w] == 'C' && arr[r] == 'D')) {
                w = w - 1;
            } else {
                arr[++w] = arr[r];
            }
        }
        return w + 1;
    }
}
