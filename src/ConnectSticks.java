import java.util.PriorityQueue;

public class ConnectSticks {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<> ();
        for(int i = 0; i < sticks.length; i++){
            pq.add(sticks[i]);
        }

        int result = 0;
        while(pq.size() > 1) {
            int newStick = pq.remove() + pq.remove();
            pq.add(newStick);
            result += newStick;
        }
        return result;
    }
}
