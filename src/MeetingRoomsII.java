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
    //Attempt #2:
    public int minMeetingRoomsII(int[][] intervals) {
        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];

        for(int i = 0; i < len; i++ ) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsPos = 0;
        for(int i = 0; i < len; i++) {
            if(starts[i] < ends[endsPos]) {
                rooms++;
            }else {
                endsPos++;
            }
        }
        return rooms;
    }
}
