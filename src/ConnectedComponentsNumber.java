public class ConnectedComponentsNumber {
    private int findParent(int[] parent, int node) {
        while(parent[node] != node) {
            node = parent[node];
        }
        return node;
    }
    public int countComponents(int[][] edges, int n) {
        if(n <= 1) return n;
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for(int[] edge : edges) {
            int x = findParent(parent, edge[0]);
            int y = findParent(parent, edge[1]);
            if(x != y) {
                parent[x] = y;
                n--;
            }
        }
        return n;
    }
}
