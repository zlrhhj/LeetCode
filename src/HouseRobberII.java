public class HouseRobberII {
    public int rob(int[] nums) {
        int len = nums.length;
        int res = 0;
        if(len <= 3) {
            for(int num : nums) {
                res = Math.max(res, num);
            }
            return res;
        }
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        dp1[0] = 0;
        dp1[1] = nums[0];
        dp1[2] = nums[1];
        dp2[0] = 0;
        dp2[1] = nums[1];
        dp2[2] = nums[2];
        for(int i = 2; i < len - 1; i++) {
            dp1[i + 1] = Math.max(dp1[i - 1], dp1[i - 2]) + nums[i];
            dp2[i + 1] = Math.max(dp2[i - 1], dp2[i - 2]) + nums[i + 1];
        }
        return Math.max(Math.max(dp1[len - 1], dp1[len - 2]), Math.max(dp2[len - 1], dp2[len - 2]));

    }
}
