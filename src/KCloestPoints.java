import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KCloestPoints {
    //    Attempt #1 : using PriorityQueue;
    public int[][] kClosest(int[][] points, int k) {
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
    //Attempt #2 just sort points Array
    public int[][] kClosest2(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return distA - distB;
        });
        return Arrays.copyOf(points, k);
    }
}
