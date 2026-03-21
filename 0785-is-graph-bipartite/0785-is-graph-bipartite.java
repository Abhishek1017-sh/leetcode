class Solution {
    static boolean check(int[][] graph,int[] color,int i,int n){
        Queue<Integer> q=new LinkedList<>();
        color[i]=0;
        q.add(i);
        while(!q.isEmpty()){
            int node=q.poll();
            for(int it:graph[node]){
                if(color[it]==-1){
                    color[it]=1-color[node];
                    q.add(it);
                }
                else if(color[it]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(check(graph,color,i,n)==false){
                    return false;
                }
            }
        }
        return true;
    }
}