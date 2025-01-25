public class NumberOfProvinces {
    private void dfs(int i, int[][] isConnected, int[] visited) {
        visited[i] = 1;
        for(int j = 0; j < isConnected.length; j++) {
            if(isConnected[i][j] == 1 && visited[j] == 0) {
                dfs(j, isConnected, visited);
            }
        }
    }
    public int findCircleNumber(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        int groupNum = 0;
        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                groupNum++;
                dfs(i, isConnected, visited);
            }
        }
        return groupNum;
    }
}
