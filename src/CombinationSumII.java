import java.util.ArrayList;
import java.util.List;

public class CombinationSumII {
    private void helper(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> comb) {
        if(target == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i - 1]) continue;
            if(target >= candidates[i]) {
                comb.add(candidates[i]);
                helper(candidates,target - candidates[i], i + 1, res, comb);
                comb.remove(comb.size() - 1);
            }
        }

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        helper(candidates,target,0,res,comb);
        return res;
    }
}
