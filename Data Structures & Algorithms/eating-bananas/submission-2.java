class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int max = piles[piles.length - 1]; //k = something 1 -- max
        int min = 1;
        int res = max;

        while (!(min > max)) {
            int k = (max + min) / 2;
            int hours = h;

            for (int i = 0; i < piles.length; i++) {
                hours -= Math.ceil((double) piles[i] / k);
                if (hours < 0) {
                    min = k + 1;
                    break;
                }
                if (i == piles.length - 1) {
                    if (hours >= 0) {
                        res = k;
                        max = k - 1;
                    } else {
                        min = k + 1;
                    }
                }
            }
        }
        return res;
    }
} 
