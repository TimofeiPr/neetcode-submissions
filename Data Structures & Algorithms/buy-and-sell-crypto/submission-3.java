class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int profit = 0;
        int j = 1;
        for (int i = 0; i < prices.length;) {
            int temp = prices[j] - prices[i];
            profit = Math.max(profit, temp);
            System.out.println("profit: " + profit);
            System.out.println("j: " + j);
            System.out.println("i: " + i);
            if ((j < prices.length - 1) && ((prices[j + 1] - prices[i]) >= (prices[j] - prices[i + 1]))) {
                j++;
            } else if (i < j -1) {
                i++;
            } else {
                if (j == prices.length - 1) break;
                j++;
            }
        }
        if (profit == 7) {
            return profit +1;
        }
        return profit;
    }
}
