import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    private boolean isSafePlace(int n, char[][] board, int row, int col) {
       //check the column
       for(int i = 0; i < row; i++) {
           if(board[i][col] == 'Q') return false;
       }
       //check the left-upper diagonal
        for(int r = row - 1, c = col - 1; r >=0 && c >= 0; r--, c--) {
            if(board[r][c] == 'Q') return false;
        }

        //check the right-upper diagonal
        for(int r = row - 1, c = col + 1; r >= 0 && c < n; r--, c++) {
            if(board[r][c] == 'Q') return false;
        }
        return true;
    }
    private void solveNQueens(int n, char[][] board, int row, List<List<String>> res) {
        if(row == n) {
            List<String> solution = new ArrayList<>();
            for(char[] rowArray : board) {
                solution.add(new String(rowArray));
            }
            res.add(solution);
            return;
        }
        for(int col = 0; col < n; col++) {
            if(isSafePlace(n, board, row, col)) {
                board[row][col] = 'Q';
                solveNQueens(n, board, row + 1, res);
                board[row][col] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> res = new ArrayList<>();
        for(char[] rowArray : board) {
            Arrays.fill(rowArray, '.');
        }
        solveNQueens(n, board, 0, res);
        return res;
    }
}
