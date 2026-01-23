class Solution {
    public long maxTotal(int[] value, int[] limit) {
        int n = value.length;
        HashMap<Integer,PriorityQueue<Integer>> mp = new HashMap<>();
        for(int i = 0; i<n; i++){
            int lim = limit[i];
            mp.putIfAbsent(lim,new PriorityQueue<>());
            PriorityQueue<Integer> pq = mp.get(lim);
            pq.add(value[i]);
            if(pq.size() > lim){
                pq.poll();
            }
        }
        long ans = 0;
        for(int key : mp.keySet()){
            PriorityQueue<Integer> pq = mp.get(key);
            while(!pq.isEmpty()){
                ans += pq.poll();
            }
        }
        return ans;
    }
}