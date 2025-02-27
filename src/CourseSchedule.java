import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
    public boolean isFinished(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;
        Map<Integer, List<Integer>> map = new HashMap();
        int[] coursesRequired = new int[numCourses];
        List<Integer> coursesDone = new ArrayList();

        for (int[] pair : prerequisites) {
            List<Integer> courseList = map.getOrDefault(pair[1], new ArrayList());
            courseList.add(pair[0]);
            map.put(pair[1], courseList);
            coursesRequired[pair[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (coursesRequired[i] == 0) {
                coursesDone.add(i);
            }
        }
        if (coursesDone.size() == 0) return false;
        for (int i = 0; i < coursesDone.size(); i++) {
            int course = coursesDone.get(i);
            List<Integer> list = map.get(course);
            for (int j = 0; list != null && j < list.size(); j++) {
                if (--coursesRequired[list.get(j)] == 0) {
                    coursesDone.add(list.get(j));
                }
            }
        }
        return coursesDone.size() == numCourses ? true : false;
    }
}
