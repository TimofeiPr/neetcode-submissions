class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1) Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // 2) Use a min-heap of size k to keep top k frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
            new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // 3) Extract results from the heap
        int[] result = new int[k];
        int idx = k - 1;
        while (!minHeap.isEmpty()) {
            result[idx--] = minHeap.poll().getKey();
        }

        return result;
    }
}
