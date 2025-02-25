public class NumberOfIslands {
    private void visit(int i, int j, char[][] grid) {
        grid[i][j] = '0';
        if(i + 1 < grid.length && grid[i + 1][j] == '1') visit(i + 1, j, grid);
        if(i - 1 >= 0 && grid[i - 1][j] == '1') visit(i - 1, j, grid);
        if(j + 1 < grid[0].length && grid[i][j + 1] == '1') visit(i, j + 1, grid);
        if(j - 1 >= 0 && grid[i][j - 1] == '1') visit(i, j - 1, grid);
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    res++;
                    visit(i, j, grid);
                }
            }
        }
        return res;
    }
}
