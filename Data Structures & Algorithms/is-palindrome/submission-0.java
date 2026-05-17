class Solution {
    public boolean isPalindrome(String s) {
        String spaceless = s.replaceAll("[^A-Za-z0-9]", "");
        spaceless = spaceless.toLowerCase();

        String first = spaceless.substring(0, (spaceless.length() / 2));
        StringBuilder secondBuilder = new StringBuilder(spaceless.substring(spaceless.length() / 2));
        String second = secondBuilder.reverse().toString();
        

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
