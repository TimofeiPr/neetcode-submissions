class Solution {
    int[] output;
    public int climbStairs(int n) {
        output = new int[n + 1];
        return recursive(n);
    }

    private int recursive(int n) {
        if (output[n] != 0) {
            return output[n];
        } else if (n == 1) {
            output[n] = 1;
            return 1;
        } else if (n == 2) {
            output[n] = 2;
            return 2;
        }
        output[n - 1] = recursive(n - 1);
        output[n - 2] = recursive(n - 2);
        return output[n - 2] + output[n - 1];
    }
}
