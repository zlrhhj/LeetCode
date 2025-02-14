public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int len = s.length();
        int begin = 0, end = 0;
        for(int i = 0; i < len - 1; i++) {
            for(int j = 0; j <= 1; j++) {
                int left = i, right = i + j;
                while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }
                left++;
                right--;
                if(right - left > end - begin) {
                    begin = left;
                    end = right;
                }
            }
        }
        return s.substring(begin, end + 1);
    }
}
