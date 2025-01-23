import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOccurences {
    public boolean uniqueOccurences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();

        for(int value : map.values()) {
           if(!set.add(value)) return false;
        }
        return true;
    }
}
