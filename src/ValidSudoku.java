public class ValidSudoku {
    public boolean isValidSudoku(char[][] boards) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] boxes = new int[9][9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {

                char c = boards[i][j];
                if( c == '.') continue;
                int num = c - '0' - 1;
                int box = ( i / 3 ) * 3 + j / 3;
                if (rows[i][num] == 1 || cols[j][num] == 1 || boxes[box][num] == 1) {
                    return false;
                } else {
                    rows[i][num] = 1;
                    cols[j][num] = 1;
                    boxes[box][num] = 1;
                }
            }

        }
        return true;
    }
}
