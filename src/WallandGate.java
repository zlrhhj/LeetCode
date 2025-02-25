public class WallandGate {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        int[][] res = new int[m][n];
        boolean change = true;
        while(change) {
            change = false;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++) {
                    if(i + 1 < m && rooms[i + 1][j] >= 0 &&  rooms[i + 1][j] < rooms[i][j]) {
                        if(rooms[i][j] > rooms[i + 1][j] + 1) {
                            rooms[i][j] = rooms[i + 1][j] + 1;
                            change = true;
                        }
                    }
                    if(i - 1 >= 0 && rooms[i - 1][j] >= 0 && rooms[i - 1][j] < rooms[i][j]) {
                        if(rooms[i][j] > rooms[i - 1][j] + 1) {
                            rooms[i][j] = rooms[i - 1][j] + 1;
                            change = true;
                        }

                    }
                    if(j + 1 < n && rooms[i][j + 1] >= 0 && rooms[i][j + 1] < rooms[i][j]) {
                        if(rooms[i][j] > rooms[i][j + 1] + 1)
                        {
                            rooms[i][j] = rooms[i][j + 1] + 1;
                            change = true;
                        }

                    }
                    if(j - 1 >= 0 && rooms[i][j - 1] >= 0 && rooms[i][j - 1] < rooms[i][j]) {
                        if(rooms[i][j] > rooms[i][j - 1] + 1) {
                            rooms[i][j] = rooms[i][j - 1] + 1;
                            change = true;
                        }
                    }
                }
            }
        }
    }
}
