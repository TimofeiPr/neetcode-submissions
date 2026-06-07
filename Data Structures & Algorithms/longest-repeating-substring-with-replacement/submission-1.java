class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        
        int j = 0; 
        int maxFrequency = 0; 
        int maxLength = 0; 

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'A']++;
            
            maxFrequency = Math.max(maxFrequency, counts[s.charAt(i) - 'A']);

            while ((i - j + 1) - maxFrequency > k) {
                counts[s.charAt(j) - 'A']--;
                j++;
            }
            maxLength = Math.max(maxLength, i - j + 1);
        }

        return maxLength;
    }
}