import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    private void backTrack(List<List<Integer>> results, List<Integer> combination, int start, int k, int n) {
        if(combination.size() == k && n == 0) {
            results.add(new ArrayList<>(combination));
        }
        for(int i = start; i <= 9; i++) {
            combination.add(i);
            backTrack(results, combination, i + 1, k, n - i);
            combination.remove(combination.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backTrack(results, combination, 1, k, n);
        return results;
    }
}
