import java.util.Arrays;

public class SuccessPairs {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m = spells.length;
        int n = potions.length;
        Arrays.sort(potions);
        int[] result = new int[m];
        for(int i = 0; i < m; i++) {
            if((long)spells[i] * (long)potions[n - 1] < success) {
                result[i] = 0;
                continue;
            }
            int left = 0, right = n - 1;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if( (long)spells[i] * (long)potions[mid] < success ) {
                    left = mid  + 1;
                } else {
                    right = mid;
                }
            }
            result[i] = m - left;
        }
        return result;
    }
}
