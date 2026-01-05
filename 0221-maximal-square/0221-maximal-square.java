class Solution {
    int a=0;
    public int maximalSquare(char[][] matrix) {
        int[][] dp=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            Arrays.fill(dp[i],-1);
        }
        rec(matrix,0,0,dp);
        return a*a;
    }
    int rec(char[][] matrix,int i,int j,int[][] dp){
        if(i>=matrix.length || j>=matrix[0].length || i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int right=rec(matrix,i,j+1,dp);
        int down=rec(matrix,i+1,j,dp);
        int dig=rec(matrix,i+1,j+1,dp);
        if(matrix[i][j]=='1'){
            dp[i][j]=1+Math.min(right,Math.min(down,dig));
            a=Math.max(a,dp[i][j]);
        }
        else{
            dp[i][j]=0;
        }
        return dp[i][j];
    }
}