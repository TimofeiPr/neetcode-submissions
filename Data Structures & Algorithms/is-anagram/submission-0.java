class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (char letter: s.toCharArray()) {
            if (mapS.containsKey(letter)) {
                int temp = mapS.get(letter); 
                mapS.put(letter, (temp + 1));
            } else {
                mapS.put(letter, 1);
            }
        }
        for (char letter: t.toCharArray()) {
            if (mapT.containsKey(letter)) {
                int temp = mapT.get(letter); 
                mapT.put(letter, (temp + 1));
            } else {
                mapT.put(letter, 1);
            }
        }

        if (mapS.equals(mapT)) {
            return true;
        } else {
            return false;
        }
    }
}
