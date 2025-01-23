import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteriods) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < asteriods.length; i++) {
            boolean pop = false;
            while(!stack.isEmpty()) {
                if(stack.peek() > 0 && asteriods[i] < 0) {
                    if(Math.abs(stack.peek()) == Math.abs(asteriods[i])) {
                        stack.pop();
                        pop = true;
                        break;
                    } else if(Math.abs(stack.peek()) > Math.abs(asteriods[i])) {
                        pop = true;
                        break;
                    } else {
                        stack.pop();
                    }
                } else {
                    break;
                }
            }
            if(!pop) stack.push(asteriods[i]);
        }
        int[] result = new int[stack.size()];
        for(int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }
        return result;
    }
}
