class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (int)(distance(a) - distance(b)));
        for (int[] point : points) {
            pq.offer(point);
        }
        int[][] arr = new int[k][];
        for (int i = 0; i < k; i++) {
            arr[i] = pq.poll();
        }
        return arr;
    }

    private double distance(int[] point) {
        return Math.pow((double) point[0], 2.0) + Math.pow((double) point[1], 2.0);
    }
}
