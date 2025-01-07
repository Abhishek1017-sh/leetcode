class Solution {
    public int countPrimes(int n) {
        int c=0;
        int[] ans=new int[n];
        for(int i=2;i<ans.length;i++){
            ans[i]=1;
        }
        for(int i=2;i*i<n;i++){
            if(ans[i]==1){
                for(int j=i*i;j<n;j+=i){
                    ans[j]=0;
                }
            }
        }
        for(int i:ans){
            if(i==1){
                c++;
            }
        }
        return c;
    }
}