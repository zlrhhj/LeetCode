import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        rooms.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= rooms.peek()){
                rooms.remove();
            }
            rooms.add(intervals[i][1]);
        }
        return rooms.size();
    }
}
