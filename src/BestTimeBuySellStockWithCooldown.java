public class BestTimeBuySellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int sold = Integer.MIN_VALUE, held = Integer.MIN_VALUE, reset = 0;
        for(int price : prices) {
            int preSold = sold;
            sold = held + price;
            held = Math.max(held, reset - price);
            reset = Math.max(preSold, reset);
        }
        return Math.max(sold, reset);
    }
}
