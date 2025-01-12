import java.util.HashMap;
import java.util.Map;

public class ArrayDegree {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int degree = 0;
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                int[] value = {1, i, i};
                map.put(nums[i], value);
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int[] value : map.values()) {
            if(value[0] == degree) {
                answer = Math.min(answer, value[2] - value[1] + 1);
            }
        }
        return answer;
    }
}
