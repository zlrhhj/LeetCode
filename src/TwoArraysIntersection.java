import java.util.HashSet;
import java.util.Set;

public class TwoArraysIntersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for(int num : nums2) {
            if(set1.contains(num)) {
                set2.add(num);
            }
        }
        int[] result = new int[set2.size()];
        int index = 0;
        for(Integer num : set2) {
            result[index++] = num;
        }
        return result;
    }
}
