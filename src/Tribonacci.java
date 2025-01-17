public class Tribonacci {
    //Attempt #1: dynamic programing
    public int tribonacci(int n) {
        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            if(i <= 1) {
                dp[i] = i;
            } else if(i == 2) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] +dp[i - 3];
            }

        }
        return dp[n];
    }
    //Attempt #2 better dynamic programming
    public int tribonacci2(int n) {
        if(n < 3) return n > 0 ? 1 : 0;
        int a = 0, b = 1, c = 1;
        for(int i = 3; i <= n; i++) {
            int temp = a + b + c;
            a = b;
            b = c;
            c = temp;
        }
        return c;
    }
}
