class Solution {
    static boolean possible(Map<Integer,List<Integer>> adj,int node,int[] color){
        Queue<Integer> que=new LinkedList<>();
        que.add(node);
        color[node]=1;
        while(!que.isEmpty()){
            int po=que.poll();
            for(int i:adj.get(po)){
                if(color[i]==color[po]){
                    return false;
                }
                else if(color[i]==-1){
                    que.add(i);
                    color[i]=1-color[po];
                }
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int i=1;i<=n;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int[] i:dislikes){
            int a=i[0];
            int b=i[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int[] color=new int[n+1];
        Arrays.fill(color,-1);
        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                if(!possible(adj,i,color)){
                    return false;
                }
            }
        }
        return true;
    }
}