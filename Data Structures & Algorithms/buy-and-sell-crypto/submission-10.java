class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;
        for (int price: prices) {
            int profit = price - minBuy;
            if (profit < 0) {
                minBuy = price;
            } else {
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        return maxProfit;
    }
}
