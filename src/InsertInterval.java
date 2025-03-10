import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> resultList = new ArrayList<>();
        boolean done = false;
        for(int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] < newInterval[0]) {
                if(intervals[i][1] < newInterval[0] || intervals[i][1] >= newInterval[1]) {
                    resultList.add(intervals[i]);
                    if(intervals[i][1] >= newInterval[1]) done = true;
                } else {
                    newInterval[0] = intervals[i][0];
                }
            } else {
                if(newInterval[1] < intervals[i][0]) {
                    if(!done) {
                        resultList.add(newInterval);
                        done = true;
                    }
                    resultList.add(intervals[i]);
                } else if(newInterval[1] <= intervals[i][1]) {
                    newInterval[1] = intervals[i][1];
                }

            }

        }
        if(!done) resultList.add(newInterval);
        int[][] result = resultList.toArray(new int[0][]);
        return result;
    }
}
