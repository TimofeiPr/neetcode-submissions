class Solution {
    /**
     * @param {number[]} heights
     * @return {number}
     */
    maxArea(heights) {
        let i = 0;
        let j = heights.length - 1;
        let output = (j - i) * Math.min(heights[i], heights[j]);;
        while (i < j) {
            
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
            output = Math.max(output, output = (j - i) * Math.min(heights[i], heights[j]));
        }
        return output;
    }
}
