class Solution {
    public int[] avoidFlood(int[] rains) {
        int n=rains.length;
        int[] ans=new int[n];
        Map<Integer,Integer> map=new HashMap<>();
        TreeSet<Integer> tree=new TreeSet<>();
        for(int i=0;i<n;i++){
            if(rains[i]==0){
                tree.add(i);
                ans[i]=1;
            }
            else{
                int lake=rains[i];
                ans[i]=-1;
                if(map.containsKey(lake)){
                    int lastday=map.get(lake);
                    Integer dry=tree.higher(lastday);
                    if(dry==null){
                        return new int[0];
                    }
                    ans[dry]=lake;
                    tree.remove(dry);
                }
                map.put(lake,i);
            }
        }
        return ans;
    }
}