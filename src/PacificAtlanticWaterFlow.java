import java.util.*;

public class PacificAtlanticWaterFlow {
    private void helper(int[][] heights, Queue<int[]> queue, int[][] visited) {
        int m = heights.length;
        int n = heights[0].length;

        while(!queue.isEmpty()) {
            int[] pos = queue.poll();

            for(int i = -1; i <= 1; i+=2) {
                int r1 = pos[0] + i, c1 = pos[1];

                if(r1 >= 0 && r1 < m && heights[r1][c1] >= heights[pos[0]][pos[1]] && visited[r1][c1] == 0) {
                    visited[r1][c1] = 1;
                    queue.add(new int[] {r1, c1});
                }
                int r2 = pos[0], c2 = pos[1] + i;
                if(c2 >= 0 && c2 < n && heights[r2][c2] >= heights[pos[0]][pos[1]] && visited[r2][c2] == 0) {
                    visited[r2][c2] = 1;
                    queue.add(new int[] {r2, c2});
                }
            }

        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();

        int m = heights.length;
        int n = heights[0].length;

        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];

        for(int i = 0; i < m; i++) {
            pacific[i][0] = 1;
            pQueue.add(new int[] {i, 0});
            atlantic[i][n - 1] = 1;
            aQueue.add(new int[] {i, n - 1});
        }

        for(int j = 0; j < n; j++) {
            pacific[0][j] = 1;
            pQueue.add(new int[]{0, j});
            atlantic[m - 1][j] = 1;
            aQueue.add(new int[] { m - 1, j});
        }
        helper(heights,pQueue,pacific);
        helper(heights,aQueue,atlantic);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    List<Integer> list = Arrays.asList(i, j);
                    res.add(list);
                }
            }
        }
        return res;
    }
}
