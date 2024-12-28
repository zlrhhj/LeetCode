import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList();
        for(int[] interval : intervals) {
            if(merged.isEmpty() || merged.get(merged.size()-1)[1] < interval[0] ){
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size()-1)[1],interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][2]);
    }

}
