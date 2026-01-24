class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        int m= mat.length;
        int[][] dp= new int[m][5001];
        for(int i=0; i<m; i++){
            for(int j=0; j<5001; j++){
                dp[i][j]=-1;
            }
        }
        return solve(mat,dp,0,target,0);
    }
    public int solve(int[][] mat, int[][] dp, int ind, int t, int val){
        if(ind==mat.length){
            return Math.abs(t-val);
        }
        if(dp[ind][val]!=-1){
            return dp[ind][val];
        }
        int min= (int)(1e9);
        for(int i=0; i<mat[0].length; i++){
            min= Math.min(min, solve(mat,dp,ind+1,t,val+mat[ind][i]));
        }
        return dp[ind][val]= min;
    }
}