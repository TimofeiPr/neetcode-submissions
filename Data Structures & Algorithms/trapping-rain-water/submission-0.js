class Solution {
    /**
     * @param {number[]} height
     * @return {number}
     */
    trap(height) {
        if (!height || height.length === 0) return 0;

        let output = 0;
        let l = 0;
        let r = height.length - 1;
        
        let lmax = 0;
        let rmax = 0;

        while (l < r) {
        
            if (height[l] < height[r]) {
                if (height[l] >= lmax) {
                    lmax = height[l];
                } else {
                    output += lmax - height[l];
                }
                l++;
            } else {
                if (height[r] >= rmax) {
                    rmax = height[r];
                } else {
                    output += rmax - height[r];
                }
                r--;
            }
        }

        return output;
    }
}