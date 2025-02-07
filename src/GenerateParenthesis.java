import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public void helper(List<String> res, String s, int left, int right, int n) {
        if(left == n && right == n) {
            res.add(s);
            return;
        }
        if(left == n) {
            helper(res, s + ")", left, right + 1, n);
        } else if( left == right) {
            helper(res, s + "(", left + 1, right, n);
        } else {
            helper(res, s + "(", left + 1, right, n);
            helper(res, s + ")", left, right + 1, n);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", 0, 0, n);
        return res;
    }
}
