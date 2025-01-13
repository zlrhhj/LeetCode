import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int len = temperatures.length;
        int[] answer = new int[len];
        for(int i = 0; i < len; i++) {
            while(!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                int[] pair = stack.pop();
                answer[pair[0]] = i - pair[0];
            }
            int[] current = {i, temperatures[i]};
            stack.add(current);
        }
        return answer;
    }
}
