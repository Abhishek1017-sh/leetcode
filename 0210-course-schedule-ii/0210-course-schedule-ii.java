class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            indeg[prerequisites[i][0]]++;
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        int[] topo=new int[numCourses];
        int i=0;
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            topo[i++]=node;
            for(int it:adj.get(node)){
                indeg[it]--;
                if(indeg[it]==0) q.add(it);
            }
        }
        if(i!=numCourses) return new int[0];
        return topo;
    }
}