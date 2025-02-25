import java.util.LinkedList;
import java.util.Queue;

public class WallandGate {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        boolean change = true;
        while(change) {
            change = false;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++) {
                    if(i + 1 < m && rooms[i + 1][j] >= 0 &&  rooms[i + 1][j] < rooms[i][j]) {
                        if(rooms[i][j] > rooms[i + 1][j] + 1) {
                            rooms[i][j] = rooms[i + 1][j] + 1;
                            change = true;
                        }
                    }
                    if(i - 1 >= 0 && rooms[i - 1][j] >= 0 && rooms[i - 1][j] < rooms[i][j]) {
                        if(rooms[i][j] > rooms[i - 1][j] + 1) {
                            rooms[i][j] = rooms[i - 1][j] + 1;
                            change = true;
                        }

                    }
                    if(j + 1 < n && rooms[i][j + 1] >= 0 && rooms[i][j + 1] < rooms[i][j]) {
                        if(rooms[i][j] > rooms[i][j + 1] + 1)
                        {
                            rooms[i][j] = rooms[i][j + 1] + 1;
                            change = true;
                        }

                    }
                    if(j - 1 >= 0 && rooms[i][j - 1] >= 0 && rooms[i][j - 1] < rooms[i][j]) {
                        if(rooms[i][j] > rooms[i][j - 1] + 1) {
                            rooms[i][j] = rooms[i][j - 1] + 1;
                            change = true;
                        }
                    }
                }
            }
        }

    }
    //Attempt #2 using BFS
    public void wallsAndGates2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] curr = queue.remove();
            int r = curr[0];
            int c = curr[1];
            if(r + 1 < m && grid[r + 1][c] == Integer.MAX_VALUE) {
                queue.add(new int[] {r + 1, c});
                grid[r + 1][c] = grid[r][c] + 1;
            }
            if(r - 1 >= 0 && grid[r - 1][c] == Integer.MAX_VALUE) {
                queue.add(new int[] {r - 1, c});
                grid[r - 1][c] = grid[r][c] + 1;
            }
            if(c + 1 < n && grid[r][c + 1] == Integer.MAX_VALUE) {
                queue.add(new int[] {r, c + 1});
                grid[r][c + 1] = grid[r][c] + 1;
            }
            if(c - 1 >= 0 && grid[r][c - 1] == Integer.MAX_VALUE) {
                queue.add(new int[] {r, c - 1});
                grid[r][c - 1] = grid[r][c] + 1;
            }
        }
    }
}
