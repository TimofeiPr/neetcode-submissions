class Solution {
    int[] max;
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        max = new int[nums.length];
        max[0] = nums[0];
        max[1] = nums[1];
        recursive(2, nums);
        return Math.max(max[max.length - 1], max[max.length - 2]);
    }

    public void recursive(int i, int[] nums) {
        if (i > nums.length - 1) {
            return;
        } else {
            if (i >= 3) {
                max[i] = nums[i] + Math.max(max[i - 2], max[i - 3]);  
            } else {
                max[i] = nums[i] + max[i - 2];
            }
            recursive(++i, nums);
        }
    }
}
