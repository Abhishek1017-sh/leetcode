class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indeg=new int[n];
        for(int[] it:edges){
            indeg[it[1]]++;
        }
        int cnt=0;
        int ans=-1;
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                cnt++;
                ans=i;
            }
        }
        if(cnt==1){
            return ans;
        }
        else{
            return -1;
        }
    }
}