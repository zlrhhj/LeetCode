public class LongestSubarray {
    public int longestSubarray(int[] nums) {
        int zero = 1;
        int start = 0, end = 0;
        for(; end < nums.length; end++) {
            if(nums[end] == 0) {
                end--;
            }
            if(zero < 0) {
                zero += 1 - nums[start];
                start++;
            }
        }
        return end - start - 1;
    }
}
