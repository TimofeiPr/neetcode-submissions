class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        for (int num : nums) {
            pq.offer(num);
        }
        int num = pq.poll();
        k--;
        while (pq.size() >= 0) {
            if (k == 0) {
                return num;
            } else {
                k--;
                num = pq.poll();
            }
        }
        return 0;
    }
}
