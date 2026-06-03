class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to achieve O(log(min(m, n))) 
        // and avoid out-of-bounds on the complementary partition 'b'
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int x = nums1.length;
        int y = nums2.length;
        
        int low = 0;
        int high = x;
        
        while (low <= high) {
            int a = (low + high) / 2;
            int b = ((x + y + 1) / 2) - a; 

            int maxLeft1 = (a == 0) ? Integer.MIN_VALUE : nums1[a - 1];
            int minRight1 = (a == x) ? Integer.MAX_VALUE : nums1[a];
            
            int maxLeft2 = (b == 0) ? Integer.MIN_VALUE : nums2[b - 1];
            int minRight2 = (b == y) ? Integer.MAX_VALUE : nums2[b];
            
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((x + y) % 2 != 0) {
                    return Math.max(maxLeft1, maxLeft2);
                }
                return ((double) Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
            } 
            else if (maxLeft1 > minRight2) {
                high = a - 1;
            } 
            else {
                low = a + 1;
            }
        }
        
        return 0.0; 
    }
}