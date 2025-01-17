public class HouseRobber {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len <= 2) return nums[len - 1];
        int dp[] =  new int[len];

        for(int i = 0; i < len; i++) {
            if(i <= 1) {
                dp[i] = nums[i];
            } else if(i == 2) {
                dp[i] = dp[i - 2];
            } else {
                dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
            }
        }
        return Math.max(dp[len - 2],dp[len - 1]);
    }

}
