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
}
