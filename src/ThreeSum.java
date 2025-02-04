import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    private void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1;
        int hi = nums.length - 1;
        while(lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if(sum > 0) {
                hi--;
            } else if(sum < 0) {
                lo++;
            }
            res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
            while(lo < hi && nums[lo] == nums[lo - 1]) {
                lo++;
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            twoSum(nums, i, res);
        }
        return res;
    }
}
