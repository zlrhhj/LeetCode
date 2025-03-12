import java.util.HashSet;
import java.util.Set;

public class MergetTripletsToFormTargetTriplet {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] initial = new int[3];
        for(int i = 0; i < triplets.length; i++) {
            if(triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2]) {
                initial[0] = Math.max(initial[0], triplets[i][0]);
                initial[1] = Math.max(initial[1], triplets[i][1]);
                initial[2] = Math.max(initial[2], triplets[i][2]);
                if(initial[0] == target[0] && initial[1] == target[1] && initial[2] == target[2]) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean mergeTripletsII(int[][] triplets, int[] target) {
        Set<Integer> set = new HashSet<>();
        for(int[] triplet : triplets) {
            if(triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) continue;
            for(int i = 0; i < 3; i++) {
                if(triplet[i] == target[i]) {
                    set.add(i);
                    if(set.size() == 3) return true;
                }
            }
        }
        return false;
    }
}
