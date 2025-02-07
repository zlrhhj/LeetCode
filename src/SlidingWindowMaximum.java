import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    //Attempt #1 : using PriorityQueue
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue((a, b) -> (nums[(int)b] - nums[(int)a]));
        int[] result = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++) {
            pq.add(i);
            if (i >= k - 1) {
                while (pq.peek() <= i - k) {
                    pq.poll();
                }
                result[i - k + 1] = nums[pq.peek()];
            }
        }
        return result;
    }
    //Attempt #2 : using Deque
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList();
        for(int i = 0; i < nums.length; i++)
        {
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.add(i);
            while(!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            if(i >= k - 1) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
}
