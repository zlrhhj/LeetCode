import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap();
        int[] preAmount = new int[numCourses];

        for(int[] p : prerequisites) {
            map.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
            preAmount[p[0]]++;
        }
        int[] order = new int[numCourses];
        int index = 0, pointer = 0;
        for(int n : preAmount) {
            if(n == 0) {
                order[index] = n;
                index++;
            }
        }
        while(pointer < index) {
            if(map.containsKey(order[pointer])) {
                for(int c : map.get(order[pointer])) {
                    if(--preAmount[c] == 0) {
                        order[index] = c;
                        index++;
                    }
                }
            }
            pointer++;
        }
        return index == numCourses ? order :new int[0];
    }
}
