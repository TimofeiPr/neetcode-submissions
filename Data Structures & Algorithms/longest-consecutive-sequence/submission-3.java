class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);


        if (nums.length == 0) {
            return 0;
        }

        int longest = 1;
        int i = 0;

        while (i < nums.length - 1) {
            int start = i;
            int len = 1;
            while (i < nums.length - 1) {
                if (nums[i + 1] == nums[i] + 1) {
                    len++;  
                    i++;
                } else if (nums[i + 1] == nums[i]) {
                    i++;    
                } else {
                    break;
                }
            }
            longest = Math.max(longest, len);
            if (i == start) {
                i++;
            }
        }

        return longest;
    }
}
