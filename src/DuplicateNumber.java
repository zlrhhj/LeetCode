public class DuplicateNumber {
    private int store(int[] nums, int cur) {
        if(nums[cur] == cur) {
            return cur;
        }
        int next = nums[cur];
        nums[cur] = cur;
        return store(nums, next);
    }
    public int findDulicate(int[] nums) {
        return store(nums, 0);
    }
}
