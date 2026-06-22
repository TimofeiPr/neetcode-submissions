public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private int cap;
    private HashMap<Integer, Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public int get(int key) {
        Node temp = this.cache.get(key);
        if (temp == null) {
            return -1;
        }
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;

        temp.next = left.next;
        temp.next.prev = temp;
        left.next = temp;
        temp.prev = left;

        return temp.val;
    }

    public void put(int key, int value) {
        Node temp;
        if (this.cache.get(key) == null) {
            if (cache.size() >= this.cap) {
                this.cache.remove(right.prev.key);
                temp = right.prev;
                temp.prev.next = right;
                right.prev = temp.prev;
            } 
            temp = new Node(key, value);
            this.cache.put(key, temp);
        } else {
            temp = this.cache.get(key);
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
            temp.val = value;
        }

        temp.next = left.next;
        temp.next.prev = temp;
        left.next = temp;
        temp.prev = left;
    }
}
