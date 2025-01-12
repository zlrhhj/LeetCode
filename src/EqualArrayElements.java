import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EqualArrayElements {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] preSum = new long[n + 1];
        List<Long> answer = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        for(int query : queries) {
            int i = bisect(nums, query);
            answer.add(preSum[n] - 2 * preSum[i] + (2 * i - n) * query);
        }
        return answer;
    }
    private int bisect(int[] nums, int query) {
        int start = 0, end = nums.length;
        while(start < end) {
            int mid = (start + end) / 2;
            if(nums[mid] < query) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}
