class Solution {
    public boolean canFinish(int V,int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int m=edges.length;
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        int[] indeg=new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                indeg[it]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        List<Integer> list=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            list.add(node);
            for(int it:adj.get(node)){
                indeg[it]--;
                if(indeg[it]==0) q.add(it);
            }
        }
        if(list.size()==V) return true;
        return false;
    }
}