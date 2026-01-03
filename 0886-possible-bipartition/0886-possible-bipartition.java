class Solution {
    static boolean bfs(int node,ArrayList<ArrayList<Integer>> adj,Set<Integer> set1,Set<Integer> set2,int[] visited){
        visited[node]=1;
        Queue<Integer> que=new LinkedList<>();
        que.add(node);
        set1.add(node);
        while(!que.isEmpty()){
            int pol=que.poll();
            for(int nei:adj.get(pol)){
                if(visited[nei]!=1 && set1.contains(pol)){
                    set2.add(nei);
                    que.add(nei);
                    visited[nei]=1;
                }
                else if(visited[nei]!=1 && set2.contains(pol)){
                    set1.add(nei);
                    que.add(nei);
                    visited[nei]=1;
                }
                else if((set1.contains(pol) && set1.contains(nei)) || (set2.contains(pol) && set2.contains(nei))){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        int[] visited=new int[n+1];
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:dislikes){
            int u=it[0];
            int v=it[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i=1;i<=n;i++){
            if(visited[i]!=1){
                if(!bfs(i,adj,set1,set2,visited)){
                    return false;
                }
            }
        }
        return true;
    }
}