import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        int len = s.length();
        explore(0, s, curr, result, len);
        return result;
    }
    public void explore(int start, String s, List<String> curr, List<List<String>> result, int len) {
        if(start >= len) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i < len; i++) {
            String subStr = s.substring(start, i + 1);
            if(isPalindrome(subStr)) {
                curr.add(subStr);
                explore(i + 1, s, curr, result, len);
                curr.remove(curr.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
