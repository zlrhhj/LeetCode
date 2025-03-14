import java.util.Arrays;

public class BestBuySellStockIV {
    public int maxProfit(int k, int[] prices) {
        int[] cost = new int[k + 1];
        int[] profit = new int[k + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        for(int i = 0; i < prices.length; i++) {
            for(int j = 1; j <= k; j++) {
                cost[j] = Math.min(cost[j], prices[i] - profit[j - 1]);
                profit[j] = Math.max(profit[j], prices[i] - cost[j]);
            }
        }
        return profit[k];
    }
}
