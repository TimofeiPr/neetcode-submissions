class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : stones) {
            pq.offer(num);
        }

        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();

            if (x > y) {
                pq.offer(x - y);
            } else {
                pq.offer(0);
            }
        }
        if (pq.size() > 0) {
            return pq.poll();
        }
        return stones[0];
    }
}
