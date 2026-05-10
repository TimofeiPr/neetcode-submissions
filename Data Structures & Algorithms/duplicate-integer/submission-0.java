class Solution {
    public boolean hasDuplicate(int[] nums) {
        while (nums.length > 0) {
            int number = nums[0];
            nums = Arrays.copyOfRange(nums, 1, nums.length);
            for (int num: nums) {
                if (num == number) {
                    return true;
                }
            }
        }
        return false;
    }
}