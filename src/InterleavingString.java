public class InterleavingString {
    public boolean interLeave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1 + l2 != s3.length()) return false;

        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;
        for(int i = 1; i <= l2; i++) {
            dp[0][i] = dp[0][i - 1] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }
        for(int i = 1; i <= l1; i++) {
            dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        for(int i = 1; i <= l1; i++) {
            for(int j = 1; j <= l2; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j -1))||(dp[i][j - 1] &&(s2.charAt(j - 1) == s3.charAt(i + j - 1)));
            }
        }
        return dp[l1][l2];
    }
}
