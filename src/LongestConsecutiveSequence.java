import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive( int[] nums ) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for(int num : set) {
            if(!set.contains(num - 1)) {
                int current = num;
                int currentStreak = 1;
                while(set.contains(current + 1)) {
                    currentStreak++;
                    current++;
                }
                longest = Math.max(longest, currentStreak);
            }
        }
        return longest;
    }
}
