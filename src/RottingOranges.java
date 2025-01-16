import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        while(!queue.isEmpty()) {
            int len = queue.size();
            for (int k = 0; k < len; k++) {
                int[] cell = queue.remove();
                int r = cell[0], c = cell[1];
                if(r + 1 < m && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    queue.add(new int[]{r + 1, c});
                }
                if(r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    queue.add(new int[] {r - 1, c});
                }
                if(c + 1 < n && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    queue.add(new int[] {r, c + 1});
                }
                if(c - 1 >= 0 && grid[r][c - 1] == 1){
                    grid[r][c - 1] = 2;
                    queue.add(new int[]{r, c - 1});
                }
            }
            if(!queue.isEmpty()) result++;
        }
        for (int[] ints : grid)
            for (int j = 0; j < n; j++)
                if (ints[j] == 1) return -1;
        return result;
    }

}
