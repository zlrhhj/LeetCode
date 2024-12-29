public class DecodeWays {
    private int count;
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        if(s.charAt(0) == '0') {
            return 0;
        } else {
            dp[0] = 1;
        }
        if(s.length() == 1) {
            return dp[0];
        }
        if(s.charAt(1) != '0') {
            dp[1] = dp[0];
        }
        if(Integer.parseInt(s.substring(0, 2)) <= 26) {
            dp[1]++;
        }
        for(int i = 2; i < s.length(); i++) {
            if(s.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            }
            if(s.charAt(i - 1) != '0' && Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }
        return dp[s.length() - 1];
    }
    public int numDecodings1(String s) {
        count = 0;
        backTrack(s, 0);
        return count;
    }
    private void backTrack(String s, int index) {
        if(index == s.length()) {
            count++;
            return;
        }
        if(s.charAt(index) == '0') {
            return;
        }
        backTrack(s, index + 1);
        if(index < s.length() - 1) {
            int num = Integer.parseInt(s.substring(index, index + 2));
            if(num <= 26) {
                backTrack(s, index + 2);
            }
        }
    }
}
