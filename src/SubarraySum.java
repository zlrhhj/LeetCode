import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSumCount = new HashMap<>();
        preSumCount.put(0, 1);
        int answer = 0;
        int preSum = 0;
        for(int num : nums) {
            preSum += num;
            answer += preSumCount.getOrDefault(preSum - k, 0);
            preSumCount.put(preSum, preSumCount.getOrDefault(preSum,0) + 1);
        }
        return answer;
    }
}
