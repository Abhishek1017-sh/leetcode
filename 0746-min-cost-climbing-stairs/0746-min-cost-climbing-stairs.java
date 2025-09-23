class Solution {
    // public static void helper(int cost[],int count,int idx){
    //     if(idx>=cost.length){
    //         return;
    //     }
    //     if(idx+1<arr.length && cost[idx]<cost[idx+1]){
    //         count+=cost[idx];
    //         helper(cost,count,idx+1);
    //     }
    //     else{
    //         count+=cost[idx];
    //         helper(cost,count,idx+2);
    //     }
    // }

    public static int helper(int arr[],int dp[],int idx){
        if(idx==0 || idx==1){
            dp[idx]=arr[idx];
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        dp[idx] = arr[idx] + Math.min(helper(arr,dp,idx-1),helper(arr,dp,idx-2));
        return dp[idx];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return Math.min(helper(cost,dp,n-1),helper(cost,dp,n-2));
    }
}
