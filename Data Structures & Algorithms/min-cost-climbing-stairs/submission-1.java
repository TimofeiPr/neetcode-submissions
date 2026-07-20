class Solution {
    int[] total;
    public int minCostClimbingStairs(int[] cost) {
        total = new int[cost.length];
        total[0] = cost[0];
        total[1] = cost[1];
        return recursive(cost, 2);        
    }

    private int recursive(int[] cost, int i) {
        if (i > cost.length - 1) {
            return Math.min(total[i - 1], total[i - 2]);
        } else {
            total[i] = cost[i] + Math.min(total[i - 1], total[i - 2]);
            return recursive(cost, i + 1);
        }
    }
}
