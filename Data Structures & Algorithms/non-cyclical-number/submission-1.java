class Solution {
    HashSet<Integer> storage;
    boolean output;
    public boolean isHappy(int n) {
        this.storage = new HashSet<Integer>();
        this.output = true;
        recursive(n);
        return output;
    }

    private void recursive(int n) {
        if (n == 1) {
            return;
        } else if (this.storage.contains(n)) {
            this.output = false;
        } else {
            storage.add(n);
            int[] digits = String.valueOf(n).chars().map(c -> c - '0').toArray();
            int out = 0;
            for (int i : digits) {
                out += i * i;
            }

            recursive(out);
        }
    }
}
