import java.util.PriorityQueue;

public class MinCostConnectPoints {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int n = points.length;
        int minCost = 0;
        int[] visited = new int[n];
        int connectedPoints = 0;
        pq.add(new int[]{0, 0});
        while(connectedPoints < n) {
            int[] top = pq.remove();
            while(visited[top[0]] == 1) {
                top = pq.remove();
            }
            visited[top[0]] = 1;
            connectedPoints++;
            minCost += top[1];
            for(int i = 1; i < n; i++) {
                if(visited[i] == 1) continue;
                int cost = Math.abs(points[top[0]][0] - points[i][0]) + Math.abs(points[top[0]][1] - points[i][1]);
                pq.add(new int[] { i, cost });
            }
        }
        return minCost;
    }
}
