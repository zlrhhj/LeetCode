import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinAbsDiff {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> pairs = new ArrayList<>();
        for(int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if(minDiff > diff) {
                minDiff = diff;
            }
        }
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i + 1] - arr[i] == minDiff) {
                pairs.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return pairs;
    }
}
