public class Search2DMatrix {
    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (matrix[i][j] == target) return true;
            }
        }
        return false;
    }
    //Attempt #2 using binary search
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while(left <= right) {
            int mid = left + ( right - left ) / 2;
            int r = mid / n;
            int c = mid % n;
            if(matrix[r][c] == target ) {
                return true;
            } else if( matrix[r][c] > target ) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
