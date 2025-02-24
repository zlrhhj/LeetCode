import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        int size = 0;
        for(int i = 0; i < nums.length; i++) {
            int start = 0;
            if(i > 0 && nums[i] == nums[i - 1]) {
                start = size;
            }
            size = res.size();
            for(int j = start; j < size; j++) {
                List<Integer> list = new ArrayList(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }
}
