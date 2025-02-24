public class WordSearch {
    private boolean wordSearch(int[][] used, char[][] board, int r, int c, String word, int index) {
        int m = board.length;
        int n = board[0].length;
        if(word.charAt(index) == board[r][c] && used[r][c] == 0) {
            if(index == word.length() - 1) return true;
            used[r][c] = 1;
            if( (r + 1 < m && wordSearch(used, board, r + 1, c, word, index + 1)) ||
                    (r - 1 >= 0 && wordSearch(used, board, r - 1, c, word, index + 1)) ||
                    (c + 1 < n && wordSearch(used, board, r, c + 1, word, index + 1)) ||
                    (c - 1 >= 0 && wordSearch(used, board, r, c - 1, word, index + 1))) {
                return true;
            }
            used[r][c] = 0;
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int[][] used = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(wordSearch(used, board, i, j, word, 0)) return true;
                }
            }
        }
        return false;
    }
}
