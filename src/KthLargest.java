import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    private int K;
    public KthLargest(int k, int[] nums) {
        this.K = k;
        for(int num : nums) {
            pq.add(num);
            if(pq.size() > k) {
                pq.remove();
            }
        }

    }
    public int add(int val) {
        pq.add(val);
        if(pq.size() > K) pq.remove();
        return pq.peek();
    }
}
