import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        //PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone : stones) {
            pq.add(stone);
        }
        while(pq.size() > 1) {
            int stone1 = pq.remove();
            int stone2 = pq.remove();
            if(stone1 > stone2) {
                pq.add(stone1 - stone2);
            }
        }
        return pq.size() > 0 ? pq.remove() : 0;
    }
}
