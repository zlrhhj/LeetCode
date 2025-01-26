import java.util.Arrays;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m  + 1][n + 1];
        //convert word1 (length is i) to word2 (length is zero) needing i steps to delete all characters
        for(int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        //convert word1(length is 0) to word2 (length is j) needing j step to insert all characters.
        for(int j = 0; j <= n; j++) {
            dp[j][0] = j;
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    /* three choices
                       #1 replace dp[i - 1][j - 1] + 1
                       #2 insert dp[i - 1][j] + 1
                       #3 delete dp[i][j - 1] + 1
                       get the minimum assign it to the dp[i][j]
                     */
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
