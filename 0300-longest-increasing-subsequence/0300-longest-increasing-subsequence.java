class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n];
        for(int i=0;i<n;i++){
            dp[i] =1;
        }
        for(int i=1;i<n;i++){
            int ele= arr[i];
            for(int j=0;j<i ;j++){
                if(ele>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}