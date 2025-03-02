import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
    /* Attempt #1  time limie exceeded*/
    private int minCost = Integer.MAX_VALUE;
    private void helper(int[][] connections, int n, int src, int dst, int k, int curCost, int[] path) {
        if( k < 0 ) return;
        if(connections[src][dst] > 0) {
            minCost = Math.min(minCost, curCost + connections[src][dst]);
        }
        for(int i = 0; i < n; i++) {
            if(connections[src][i] > 0 && curCost + connections[src][i] < minCost) {
                path[i] = 1;
                helper(connections, n, i, dst, k - 1,  curCost + connections[src][i], path);
                path[i] = 0;
            }
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] connections = new int[n][n];
        for(int i = 0; i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int cost= flights[i][2];

            connections[from][to] = cost;
        }
        int[] path = new int[n];
        helper(connections, n, src, dst, k, 0, path);
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        int[][] connections = new int[n][n];
        for(int[] f : flights) {
            connections[f[0]][f[1]] = f[2];
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0 });

        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        int stops = 0;

        while(stops <= k && !queue.isEmpty()) {
            int[] p = queue.remove();
            int curSrc = p[0];
            int cost = p[1];
            for(int i = 0; i < n; i++) {
                if(connections[curSrc][i] > 0 && costs[i] > cost + connections[curSrc][i]) {
                    costs[i] = cost + connections[curSrc][i];
                    queue.add(new int[]{i,  cost + connections[curSrc][i]});
                }
            }
            stops++;
        }
        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }
}
