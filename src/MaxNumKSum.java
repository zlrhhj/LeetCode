import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxNumKSum {
    //Attempt #1 using HashMap
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            if(map.getOrDefault(k - nums[i], 0) > 0) {
                result++;
                map.put(k - nums[i], map.get(k - nums[i]) - 1);
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return result;
    }
    //Attempt #2 using two pointers
    public int maxOperations2(int nums[], int k) {
        int result = 0;
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if( sum == k ) {
                result++;
                right--;
                left++;
            } else if( sum > k ) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
