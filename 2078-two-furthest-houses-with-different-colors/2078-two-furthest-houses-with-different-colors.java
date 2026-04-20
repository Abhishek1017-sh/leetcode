class Solution {
    public int maxDistance(int[] colors) {
        int n=colors.length;
        int ans=-1;
        for(int i=n-1;i>=0;i--){
            if(colors[i]!=colors[0]){
                ans=Math.max(ans,i);
            }
        }
        for(int i=0;i<n;i++){
            if(colors[i]!=colors[n-1]){
                ans=Math.max(ans,n-1-i);
            }
        }
        return ans;
    }
}