class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int m = r / 2;


        while (l <= r) {
            if (nums[m] < nums[r]) {
                r = m;
                m = (l + r) / 2;
            } else {
                l = m + 1;
                m = (l + r) / 2;
            }
        }
        return nums[m];
    }
}
