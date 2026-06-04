class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int profit = 0;
        for (int price: prices) {
            profit = Math.max(profit, (price - minBuy));
            minBuy = Math.min(price, minBuy);
        }
        return profit;
    }
}
