import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualRowColumnPairs {
    public int equalPairs(int[][] grid) {
        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        int n = grid.length;
        for(int i = 0; i < n; i++) {
            map.put(Arrays.toString(grid[i]), map.getOrDefault(Arrays.toString(grid[i]),0) + 1);
        }

        for(int i = 0; i < n; i++) {
            int[] column = new int[n];
            for(int j = 0; j < n; j++){
                column[j] = grid[j][i];
            }
            if(map.containsKey(Arrays.toString(column))) {
                result += map.get(Arrays.toString(column));
            }
        }
        return result;
    }
}
