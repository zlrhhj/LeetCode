import java.util.Comparator;
import java.util.PriorityQueue;

public class KCloestPoints {
    public int[][] kCloest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0] * a[0] + a[1]*a[1]));
        for(int[] point : points) {
            pq.add(point);
        }
        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++) {
            res[i] = pq.remove();
        }
        return res;
    }
}
