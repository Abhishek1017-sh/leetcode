class Pair{
    int first;
    Set<Integer> second;
    Pair(int first,Set<Integer> second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int shortestPathLength(int[][] graph) {
        int n=graph.length;
        Queue<Pair> q=new LinkedList<>();
        Set<String> seen=new HashSet<>();
        for(int i=0;i<n;i++){
            Set<Integer> set=new HashSet<>();
            set.add(i);
            q.add(new Pair(i,set));
            seen.add(i+"-"+set.toString());
        }
        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair curr=q.poll();
                int node=curr.first;
                Set<Integer> s=curr.second;
                if(s.size()==n) return steps;
                for(int nei:graph[node]){
                    Set<Integer> newset=new HashSet<>(s);
                    newset.add(nei);
                    String key=nei+"-"+newset.toString();
                    if(!seen.contains(key)){
                        seen.add(key);
                        q.add(new Pair(nei,newset));
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}