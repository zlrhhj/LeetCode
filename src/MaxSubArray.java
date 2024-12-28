public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int currentSubArray = nums[0];
        int maxSubArray = nums[0];
        for(int i = 1; i < nums.length; i++) {
            currentSubArray = Math.max(nums[i], nums[i] + currentSubArray);
            maxSubArray = Math.max(currentSubArray, maxSubArray);
        }
        return maxSubArray;
    }
}
