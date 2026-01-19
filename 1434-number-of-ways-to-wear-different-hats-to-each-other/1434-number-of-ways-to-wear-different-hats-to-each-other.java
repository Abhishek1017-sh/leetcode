class Solution {
    public int numberWays(List<List<Integer>> hats) {
        int mod=1000000007;
        int n=hats.size();
        List<Integer>[] map=new ArrayList[41];
        for(int i=1;i<=40;i++){
            map[i]=new ArrayList<>();
        }
        for(int p=0;p<n;p++){
            for(int h:hats.get(p)){
                map[h].add(p);
            }
        }
        int max=1<<n;
        long[] dp=new long[max];
        dp[0]=1;
        for(int h=1;h<=40;h++){
            long[] next=dp.clone();
            for(int m=0;m<max;m++){
                if(dp[m]==0)continue;
                for(int p:map[h]){
                    if((m&(1<<p))==0){
                        int nm=m|(1<<p);
                        next[nm]=(next[nm]+dp[m])%mod;
                    }
                }
            }
            dp=next;
        }
        return (int)dp[max-1];
    }
}