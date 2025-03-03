public class NQueensII {
    private int total = 0;
    private boolean isSafePlace(int n, int[][] board, int row, int col) {
        //check the col
        for(int i = 0; i < row; i++) {
            if(board[i][col] == 1) return false;
        }
        //cheak the left-upper diagonal
        for(int r = row - 1, c = col - 1; r >= 0 && c >= 0; c--, r--) {
            if(board[r][c] == 1) return false;
        }
        //check the right-upper diagonal

        for(int r = row - 1, c = col + 1; r >= 0 && c < n; r--, c++) {
            if(board[r][c] == 1) return false;
        }
        return true;
    }
    private void solveNQueens(int n, int[][] board, int row) {
        if(row == n) {
            total++;
            return;
        }
        for(int col = 0; col < n; col++) {
            if(isSafePlace(n, board, row, col)) {
                board[row][col] = 1;
                solveNQueens(n, board, row + 1);
                board[row][col] = 0;
            }
        }
    }
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        solveNQueens(n, board, 0);
        return total;
    }
}
