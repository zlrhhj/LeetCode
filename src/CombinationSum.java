import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    private List<List<Integer>> result;
    private int[] canidates;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
       result = new ArrayList<>();
       canidates = nums;
       backTrack(new ArrayList<>(), 0, target);
       return result;
    }
    public void backTrack(List<Integer> path, int index, int target) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i < canidates.length; i++) {
            path.add(canidates[i]);
            backTrack(path, i, target - canidates[i]);
            path.remove(path.size() - 1);
        }
    }

}
