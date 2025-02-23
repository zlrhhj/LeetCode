public class DuplicateNumber {
    private int store(int[] nums, int cur) {
        if(nums[cur] == cur) {
            return cur;
        }
        int next = nums[cur];
        nums[cur] = cur;
        return store(nums, next);
    }
    public int findDuplicate(int[] nums) {
        return store(nums, 0);
    }
//    Attempt #2 :
    public int findDuplicate2(int[] nums) {
        while(nums[0] != nums[nums[0]]) {
            int temp = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = temp;
        }
        return nums[0];
    }
}
