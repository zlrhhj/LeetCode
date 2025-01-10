public class CountStrictlyIncreasingSubarray {
    public long countSubarray(int[] nums) {
        int len = nums.length;
        long[] dp = new long[len];
        dp[0] = 1;
        for(int i = 1; i < len; i++) {
            if(nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1];
            }
            dp[i] += 1;
        }

        long ans = 0;
        for(long l : dp) {
            ans += l;
        }
        return ans;
    }
}
