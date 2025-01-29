import java.util.PriorityQueue;

public class MaximumSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for(int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        long result = 0;
        for(int[] pair : pairs) {
            pq.add(pair[0]);
            sum += pair[0];
            if(pq.size() > k) {
                sum -= pq.poll();
            }
            if(pq.size() == k) {
                result = Math.max(result, sum * pair[1]);
            }
        }
        return result;
    }
}
