class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        
        int left = 0, right = 0;
        int requiredMatches = targetMap.size();
        int formedMatches = 0;
        
        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;

        while (right < s.length()) {
            char rChar = s.charAt(right);
            windowMap.put(rChar, windowMap.getOrDefault(rChar, 0) + 1);

            if (targetMap.containsKey(rChar) && windowMap.get(rChar).equals(targetMap.get(rChar))) {
                formedMatches++;
            }

            while (formedMatches == requiredMatches) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIdx = left;
                }

                char lChar = s.charAt(left);
                windowMap.put(lChar, windowMap.get(lChar) - 1);

                if (targetMap.containsKey(lChar) && windowMap.get(lChar) < targetMap.get(lChar)) {
                    formedMatches--;
                }
                
                left++; 
            }

            right++; 
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}


