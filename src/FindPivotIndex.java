public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int total = 0, leftsum = 0;
        for(int num : nums) total += num;
        for(int i = 0; i < nums.length; i++) {
            if(total - leftsum - nums[i] == leftsum) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}
