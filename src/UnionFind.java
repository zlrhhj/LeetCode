public class UnionFind {
    private int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for(int node = 0; node < n; node++) {
            parent[node] = node;
        }
    }
    public int find(int A) {
        while(parent[A] != A) {
            A = parent[A];
        }
        return A;
    }
    public boolean union(int A, int B) {
        int rootA = find(A);
        int rootB = find(B);
        if(rootA == rootB){
            return false;
        }
        parent[rootA] = rootB;
        return true;
    }
}
