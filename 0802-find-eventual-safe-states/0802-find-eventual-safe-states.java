class Solution {
    private boolean dfs(int node,int[][] graph,int[] vis,int[] pathvis,int[] check){
        vis[node]=1;
        pathvis[node]=1;
        check[node]=0;
        for(int nei:graph[node]){
            if(vis[nei]==0){
                if(dfs(nei,graph,vis,pathvis,check)==true) return true; 
            }
            else if(pathvis[nei]==1){
                return true;
            }
        }
        check[node]=1;
        pathvis[node]=0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[] vis=new int[n];
        int[] pathvis=new int[n];
        int[] check=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(i,graph,vis,pathvis,check);
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(check[i]==1) list.add(i);
        }
        return list;
    }
}