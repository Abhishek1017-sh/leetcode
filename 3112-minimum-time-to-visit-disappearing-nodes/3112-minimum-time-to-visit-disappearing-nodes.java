class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            if(e[0] == e[1]){
                continue;
            }
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int d = cur[1];
            if(dis[node] < d) continue;
            for (int[] nbr : adj.get(node)) {
                int next = nbr[0];
                int wt = nbr[1];
                if (d + wt < dis[next] && d + wt < disappear[next]) {
                    dis[next] = d + wt;
                    pq.add(new int[]{next, dis[next]});
                }
            }
        }
        for(int i = 0; i < dis.length; i++){
            if(dis[i] == Integer.MAX_VALUE){
                dis[i] = -1;
            }
        }
        return dis;
    }
}