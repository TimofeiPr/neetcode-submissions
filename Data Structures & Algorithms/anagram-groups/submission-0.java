class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> outputMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            
            if (!outputMap.containsKey(sortedStr)) {
                outputMap.put(sortedStr, new ArrayList<>());
            }
            outputMap.get(sortedStr).add(strs[i]);
        }
        return new ArrayList<>(outputMap.values());
    }
}
