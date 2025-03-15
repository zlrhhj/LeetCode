public class MaxAreaofIsland {
    private int calculateArea(int[][] grid, int r, int c) {
        if(r >= grid.length || r < 0 || c < 0 ||c >= grid[0].length || grid[r][c] != 1) return 0;
        grid[r][c] = 0;
        return calculateArea(grid, r + 1, c) + calculateArea(grid, r - 1, c) + calculateArea(grid, r, c+1) + calculateArea(grid, r, c - 1) + 1;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, calculateArea(grid, r, c));
                }
            }
        }
        return maxArea;
    }
}
