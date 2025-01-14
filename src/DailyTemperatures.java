import java.util.Stack;

public class DailyTemperatures {
    //using reverse iterating, Space Complexity is O(1)
    public int[] dailyTemperatures1(int[] temperatures) {
        int len = temperatures.length;
        int answer[] = new int[len];
        int hottest = 0;

        for(int i = len - 1; i >= 0; i--) {
            int currentDay = i;
            int currentTemp = temperatures[currentDay];
            if(currentTemp >= hottest) {
                hottest = currentTemp;
                continue;
            }
            int days = 1;
            while(temperatures[currentDay + days] <= currentTemp ) {
                days += answer[currentDay + days];
            }
            answer[currentDay] = days;
        }
        return answer;
    }
    //using Stack Space Complexity is O(N)
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
