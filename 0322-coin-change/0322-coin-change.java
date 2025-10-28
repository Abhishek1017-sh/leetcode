class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];
        int max=amount+1;
        Arrays.fill(dp,max);
        dp[0]=0;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j]=Math.min(dp[j],1+dp[j-coins[i]]);
            }
        }
        return dp[amount]==max ? -1 : dp[amount];
    }
}