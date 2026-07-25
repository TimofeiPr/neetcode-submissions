class Solution {
    public int hammingWeight(int n) {
        int output = 0;

        for (char c : Integer.toBinaryString(n).toCharArray()) {
            if (c == '1') {
                output++;
            }
        }
        return output;
    }
}
