public class TargetSum {
    private int res = 0;
    private void backTrack(int[] nums, int target, int current, int sum) {
        if(current == nums.length && sum == target) {
            res++;
            return;
        }
        if(current < nums.length) {
            backTrack(nums, target, current + 1, sum + nums[current]);
            backTrack(nums, target, current + 1, sum - nums[current]);
        }
    }
    public int findTargetSumWays(int[] nums, int target) {
        backTrack(nums,target, 0, 0);
        return res;
    }
}
