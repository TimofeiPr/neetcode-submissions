class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> target = new HashMap<Character, Integer>();

        for (int i = 0; i < s1.length(); i++) {
            if (target.get(s1.charAt(i)) != null) {
                target.put(s1.charAt(i), target.get(s1.charAt(i)) + 1);
            } else {
                target.put(s1.charAt(i), 1);
            }
        }

        HashMap<Character, Integer> window = new HashMap<Character, Integer>();

        int j = 0;
        int i = 0;
        
        while (j < s2.length()) {
            char rightChar = s2.charAt(j);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            if (j - i + 1 > s1.length()) {
                char leftChar = s2.charAt(i);
                if (window.get(leftChar) == 1) {
                    window.remove(leftChar);
                } else {
                    window.put(leftChar, window.get(leftChar) - 1);
                }
                i++; 
            }

            if (window.equals(target)) {
                return true;
            }

            j++;
        }
        return false;
    }
}
