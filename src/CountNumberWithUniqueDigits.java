public class CountNumberWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];
        if(n == 0) return 1;
        if(n >= 1) {
            dp[0] = 1;
            dp[1] = 9;
        }
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] * (11 - i);
        }
        int result = 0;
        for(int num : dp) {
            result += num;
        }
        return result;
    }
}
