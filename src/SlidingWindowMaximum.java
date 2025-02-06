import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue((a, b) -> (nums[(int)b] - nums[(int)a]));
        int[] result = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++) {
            pq.add(i);
            if (pq.size() >= k) {
                while (pq.peek() <= i - k) {
                    pq.poll();
                }
                result[i - k + 1] = nums[pq.peek()];
            }
        }
        return result;
    }
}
