public class PalindromicSubstrings {
    public int countSubstring(String s) {
        int n = s.length();
        int ans = n;
        for(int i = 0; i < n - 1; i++) {
            int left = i, right = i + 1;
            while(left >= 0 && right <= n - 1 && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
            left = i - 1;
            right = i + 1;
            while(left >= 0 && right <= n - 1 && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }

        }
        return ans;
    }
}
