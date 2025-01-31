import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    int counter;
    private Queue<Integer> queue ;
    public RecentCounter(){
        counter = 0;
        queue = new LinkedList<>();
    }
    public int ping(int t) {
        queue.add(t);
        counter++;
        while(queue.peek() < t - 3000) {
            queue.remove();
            counter--;
        }
        return counter;
    }
}
