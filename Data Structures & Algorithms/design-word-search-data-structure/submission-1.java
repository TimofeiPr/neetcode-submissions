class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode(null);
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            cur = cur.map.computeIfAbsent(c, ch -> new TrieNode(ch));
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, TrieNode root) {
        if (word.equals("")) {
            return root.isEnd;
        } else {
            char c = word.charAt(0);
            String rest = word.substring(1);
            if (c == '.') {
                boolean output = false;
                for (Character chr : root.map.keySet()) {
                    if (output == true) break;
                    output = search(rest, root.map.get(chr));
                }
                return output;
            } else {
                if (root.map.get(c) == null) return false;
                return search(rest, root.map.get(c));
            }
        }
    }
}

class TrieNode {
    public Character c;
    public boolean isEnd = false;
    public HashMap<Character, TrieNode> map = new HashMap<>();
    public TrieNode(Character c) {
        this.c = c;
    }
}
