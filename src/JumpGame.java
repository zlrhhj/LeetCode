public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--) {
            for(int j = i; j < i + nums[i] && j < n; j++) {
                if(dp[j] == 1) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[0] == 1;
    }
}
