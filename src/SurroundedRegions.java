public class SurroundedRegions {
    private void helper(char[][] board, int r, int c) {
        int m = board.length;
        int n = board[0].length;
        board[r][c] = 'Y';
        if(r + 1 < m && board[r + 1][c] == 'O') {
            helper(board, r + 1, c);
        }
        if(r - 1 >= 0 && board[r - 1][c] == 'O') {
            helper(board, r - 1, c);
        }
        if(c + 1 < n && board[r][c + 1] == 'O') {
            helper(board, r, c + 1);
        }
        if(c - 1 >= 0 && board[r][c - 1] == 'O') {
            helper(board, r, c - 1);
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') {
                helper(board, i, 0);
            }
            if(board[i][n - 1] == 'O') {
                helper(board, i, n - 1);
            }
        }
        for(int j = 1; j < n -1; j++) {
            if(board[0][j] == 'O') {
                helper(board, 0, j);
            }
            if(board[m - 1][j] == 'O') {
                helper(board, m - 1, j);
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
