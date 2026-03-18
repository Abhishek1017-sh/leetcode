class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=isConnected.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int[] vis=new int[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                cnt++;
                dfs(vis,adj,i);
            }
        }
        return cnt;
    }
    static void dfs(int[] vis,ArrayList<ArrayList<Integer>> adj,int node){
        vis[node]=1;
        for(int nbr:adj.get(node)){
            if(vis[nbr]==0){
                dfs(vis,adj,nbr);
            }
        }
    }
}