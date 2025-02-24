import java.util.ArrayList;
import java.util.List;

public class Permuations {
    private List<List<Integer>> res = new ArrayList<>();
    private void helper(int[] nums, List<Integer> comb) {
        if(comb.size() == nums.length) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for(int num : nums) {
            if(comb.contains(num)) continue;
            comb.add(num);
            helper(nums, comb);
            comb.remove(comb.size() - 1);
        }
    }
    public List<List<Integer>> permutations(int[] nums) {
        List<Integer> comb = new ArrayList<>();
        helper(nums, comb);
        return res;
    }
}
