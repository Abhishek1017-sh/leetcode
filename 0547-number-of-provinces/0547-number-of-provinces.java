class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = isConnected.length;
        int c = 0;
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    map.get(i).add(j);
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int key: map.keySet()){
            if(visited.contains(key)){
                continue;
            }
            q.add(key);
            c++;
            while(!q.isEmpty()){
                int rv = q.poll();
                if(visited.contains(rv)){
                    continue;
                }
                visited.add(rv);
                for(int nbrs: map.get(rv)){
                    if(!visited.contains(nbrs)){
                        q.add(nbrs);
                    }
                }
            }
            
        }
        return c;
    }
}