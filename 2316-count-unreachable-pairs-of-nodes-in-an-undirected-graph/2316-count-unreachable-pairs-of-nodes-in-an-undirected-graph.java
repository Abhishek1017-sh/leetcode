class Solution {
    static int dfs(Map<Integer,List<Integer>> map,int node,int[] vis){
        vis[node]=1;
        int c=1;
        for(int i:map.get(node)){
            if(vis[i]==-1){
                c+=dfs(map,i,vis);
            }
        }
        return c;
    } 
    public long countPairs(int n, int[][] edges) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] i:edges){
            int a=i[0];
            int b=i[1];
            map.get(a).add(b);
            map.get(b).add(a);
        }
        long result=0;
        long rem=n;
        int[] vis=new int[n+1];
        Arrays.fill(vis,-1);
        for(int i=0;i<n;i++){
            if(vis[i]==-1){
                int c=dfs(map,i,vis);
                result+=(c*(rem-c));
                rem-=c;
            }
        }
        return result;
    }
}