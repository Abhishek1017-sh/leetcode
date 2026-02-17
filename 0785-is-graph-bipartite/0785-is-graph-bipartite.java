class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        for(int i=0;i<n;i++){
            if(color[i]==0){
                Queue<Integer> que=new LinkedList<>();
                que.offer(i);
                color[i]=1;
                while(!que.isEmpty()){
                    int node=que.poll();
                    for(int nei:graph[node]){
                        if(color[nei]==0){
                            color[nei]=-color[node];
                            que.offer(nei);
                        }
                        else if(color[nei]==color[node]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}