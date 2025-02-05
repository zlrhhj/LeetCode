public class LongestRepeatingCharReplace {
    private int helper(String s, char c, int k) {
        int begin = 0, end = 0;
        for(; end < s.length(); end++) {
            int cur = s.charAt(end);
            if(cur != c) {
                k--;
            }
            if(k < 0) {
                k += s.charAt(begin) == c ? 0: 1;
                begin++;
            }
        }
        return end - begin;
    }
    public int characterReplacement(String s, int k) {
        int res = 0;
        for(int i = 0; i < 26; i++) {
            res = Math.max(res, helper(s, (char)('A' + i), k));
        }
        return res;
    }
}
