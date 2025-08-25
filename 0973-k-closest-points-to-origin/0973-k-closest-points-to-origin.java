class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-heap by distance
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for (int i = 0; i < points.length; i++) {
            int[] co = points[i];
            int x = co[0];
            int y = co[1];
            int dis = x * x + y * y; // squared distance

            pq.add(new int[]{dis, x, y});

            if (pq.size() > k) {
                pq.poll(); // remove farthest
            }
        }

        int[][] res = new int[k][2];
        for (int j = 0; j < k; j++) {
            int[] triplet = pq.poll();
            res[j][0] = triplet[1];
            res[j][1] = triplet[2];
        }

        return res;
    }
}
