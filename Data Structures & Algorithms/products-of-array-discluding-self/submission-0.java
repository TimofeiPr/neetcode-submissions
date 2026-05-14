class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = max * nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int zeroMax;
                if (i != 0) {
                    zeroMax = nums[0];
                    for (int j = 1; j < nums.length; j++) {
                        if (i == j) {
                            continue;
                        }
                        zeroMax = zeroMax * nums[j];
                    }
                } else if (i != 1) {
                    zeroMax = nums[1];
                    for (int j = 0; j < nums.length; j++) {
                        if (i == j || j == 1) {
                            continue;
                        }
                        zeroMax = zeroMax * nums[j];
                    }
                } else {
                    zeroMax = 0;
                }
                
                output[i] = zeroMax;
            }
            if (nums[i] != 0) {
                output[i] = max / nums[i];
            }
        }
        return output;
    }
}  
