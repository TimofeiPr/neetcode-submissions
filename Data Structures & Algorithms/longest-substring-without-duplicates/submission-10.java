class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        int maxLength = 0;
        int[] alphabet = new int [128];
        int j = 0;
        int length = 0;

        for (int i = 0; i < c.length;) {
            int value = (c[j + i]);
            if (alphabet[value] != 0) {
                maxLength = Math.max(length, maxLength);
                length = 0;
                alphabet = new int [128];
                j = 0;
                i++;
                continue;
            }
            
            alphabet[value] = 1;
            length++;
            j++;
            if(j + i == c.length) {
                maxLength = Math.max(length, maxLength);
                return maxLength;
            }
        }
        return 0;
    }
}
