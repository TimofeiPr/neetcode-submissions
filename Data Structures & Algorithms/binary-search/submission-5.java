class Solution {
    public int search(int[] nums, int target) {
        int bottom = 0;
        int top = nums.length - 1; 

        while (bottom <= top) {
            int middle = bottom + (top - bottom) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                bottom = middle + 1;
            } else {
                top = middle - 1;   
            }
        }  
        return -1; 
    }
}
