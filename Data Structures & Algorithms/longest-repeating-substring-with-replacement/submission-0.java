class Solution {
    public int characterReplacement(String s, int k) {
        // Array to store the count of each character (A-Z) in the current window
        int[] counts = new int[26];
        
        int j = 0; // Left pointer
        int maxFrequency = 0; // Highest frequency of a single character in the current window
        int maxLength = 0; // Result

        for (int i = 0; i < s.length(); i++) {
            // Add the current character to the window count
            counts[s.charAt(i) - 'A']++;
            
            // Update the maximum frequency found in the current window
            maxFrequency = Math.max(maxFrequency, counts[s.charAt(i) - 'A']);

            // Current window size is (i - j + 1)
            // Number of replacements needed = window size - maxFrequency
            while ((i - j + 1) - maxFrequency > k) {
                // Shrink the window from the left
                counts[s.charAt(j) - 'A']--;
                j++;
            }

            // Update the maximum length of a valid window
            maxLength = Math.max(maxLength, i - j + 1);
        }

        return maxLength;
    }
}