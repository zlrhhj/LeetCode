public class BestBuySellStock {
    public int maxProfit(int[] prices) {
        int currentMin = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > currentMin) {
                profit = Math.max(profit, prices[i] - currentMin);
            } else if (currentMin > prices[i]) {
                currentMin = prices[i];
            }
        }
        return profit;
    }
}
