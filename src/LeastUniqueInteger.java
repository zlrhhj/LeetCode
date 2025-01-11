import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastUniqueInteger {
    public int findLeastNumOfUniqueInts (int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(map.values());
        while(k > 0) {
            k = k - pq.poll();
        }
        return k == 0 ? pq.size() : pq.size() + 1;
    }
}
