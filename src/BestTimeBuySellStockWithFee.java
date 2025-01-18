public class BestTimeBuySellStockWithFee {
    //Attempt #1 dynamic programming
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] hold = new int[n];
        int[] free = new int[n];
        hold[0] = -prices[0];
        for(int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], free[i - 1] - prices[i]);
            free[i] = Math.max(free[i - 1], hold[i - 1] + prices[i] - fee);
        }
        return free[n - 1];
    }

    //Attemp #2  dynamic programming with less Space complexity
    public int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        int hold = -prices[0];
        int free = 0;
        for(int i = 1; i < n; i++) {
            hold = Math.max(hold, free - prices[i]);
            free = Math.max(free, hold + prices[i] - fee);
        }
        return free;
    }
}
