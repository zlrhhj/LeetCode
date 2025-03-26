public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] zeroCol = new int[n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    for(int k = 0; k < n; k++) {
                        if(matrix[i][k] == 0){
                            zeroCol[k] = 1;
                        } else {
                            matrix[i][k] = 0;
                        }
                    }
                    break;
                }
            }
        }
        for(int c = 0; c < n; c++) {
            if(zeroCol[c] == 1) {
                for(int i = 0; i < m; i++) {
                    matrix[i][c] = 0;
                }
            }
        }

    }
    //Atempt #2 using O(1) space complexity
    public void setZeroesII(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean isCol = false;

        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) isCol = true;
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[0][j] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] == 0) {
            for(int j = 1; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if(isCol) {
            for(int i = 1; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
