import java.util.Stack;

public class LargestRectangleInHistogram {
    //Attempt #1 : brute force  ---- time limit exceeded
    private int leftSmall(int[] heights, int index) {
        int i = index;
        while(i >= 0) {
            if(heights[i] < heights[index]) {
                return i + 1;
            }
            i--;
        }
        return 0;
    }
    private int rightSmall(int[] heights, int index) {
        int i = index;
        while(i < heights.length) {
            if(heights[i] < heights[index]) {
                return i - 1;
            }
            i++;
        }
        return heights.length - 1;
    }
    public int largestRectangleArea(int[] heights) {
        int maxRect = 0;
        for (int i = 0; i < heights.length; i++) {
            int curr = heights[i];
            int l = leftSmall(heights, i);
            int r = rightSmall(heights, i);
            maxRect = Math.max(maxRect, (r - l + 1) * curr);
        }
        return maxRect;
    }

    //Attempt #2 using Stack
    public int largestRectangleAreaII(int[] heights) {
        int len = heights.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;

        for(int i = 0; i < len; i++) {
            while(stack.peek()  != -1 && heights[stack.peek()] > heights[i]) {
                int j = stack.pop();
                maxArea = Math.max(maxArea, (j - stack.peek() - 1) * heights[j]);
            }
            stack.push(i);
        }
        while(stack.peek() != -1) {
            int j = stack.pop();
            maxArea = Math.max(maxArea, (len - stack.peek() - 1) * heights[j]);
        }
        return maxArea;
    }

}
