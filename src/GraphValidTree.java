import java.util.*;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        Map<Integer, List<Integer>> map = new HashMap();

        for(int[] edge : edges) {
            map.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
        }

        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()) {
            int node = queue.remove();
            if(!map.containsKey(node)) continue;
            for(int neighbor : map.get(node)) {
                if(parent[node] == neighbor) continue;
                if(parent[neighbor] != -1) return false;
                queue.add(neighbor);
                parent[neighbor] = node;
            }
        }
        for(int i = 1; i < n; i++) {
            if(parent[i] == -1) return false;
        }
        return true;
    }
}
