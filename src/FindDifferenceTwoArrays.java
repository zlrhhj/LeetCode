import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDifferenceTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> comSet = new HashSet<>();
        List<List<Integer>> answer = new ArrayList<>();

        for(int num : nums1) {
            set1.add(num);
        }

        for(int num : nums2) {
            if(set1.contains( num )) {
                comSet.add( num );
                set1.remove( num );
            } else if(!comSet.contains( num )) {
                set2.add(num);
            }
        }
        answer.add(new ArrayList<>(set1));
        answer.add(new ArrayList<>(set2));
        return answer;
    }
}
