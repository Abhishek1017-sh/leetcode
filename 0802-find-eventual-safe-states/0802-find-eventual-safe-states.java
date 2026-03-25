class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<List<Integer>> adjrev=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjrev.add(new ArrayList<>());
        }
        int[] indeg=new int[n];
        for(int i=0;i<n;i++){
            for(int it:graph[i]){
                adjrev.get(it).add(i);
                indeg[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            ans.add(node);
            for(int it:adjrev.get(node)){
                indeg[it]--;
                if(indeg[it]==0) q.add(it);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}