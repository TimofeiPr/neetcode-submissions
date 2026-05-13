class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String str: strs) {
            builder.append(str);
            builder.append("-----");
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        StringBuilder word = new StringBuilder();
        ArrayList<String> list = new ArrayList<String>();
        char[] chars = str.toCharArray();
        boolean isNew = false;
        for (int i = 0; i < chars.length - 4; i++) {
            if (chars[i] == '-') {
                isNew = true;
                for (int j = i + 1; j < i + 5; j++) { 
                    if (chars[j] != '-') {
                        isNew = false;
                    }
                }
                if (isNew == true) {
                    list.add(word.toString());
                    word.setLength(0);
                    i += 4;
                    continue;
                }
            } 
            word.append(chars[i]);
        }

        return list;
    }
}