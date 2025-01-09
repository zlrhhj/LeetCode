import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxEventsAttended {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int ans = 0;
        int index = 0; //events index;

        for(int day = 1; day <= 100000; day++) {
            while(!queue.isEmpty() && queue.peek() < day) {
                queue.poll();
            }
            while(index < events.length && events[index][0] == day) {
                queue.add(events[index++][1]);
            }
            if(!queue.isEmpty() && queue.peek() >= day) {
                ans++;
                queue.poll();
            }
        }
        return ans;
    }
}
