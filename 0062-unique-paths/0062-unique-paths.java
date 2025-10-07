class Solution {
    // public int uniquePaths(int m, int n){
    //     return countPaths(0, 0, m, n);
    // }
    // static int countPaths(int i, int j, int m, int n) {
    //     if (i == m - 1 && j == n - 1) return 1; // reached destination
    //     if (i >= m || j >= n) return 0; // out of bounds
    //     return countPaths(i + 1, j, m, n) + countPaths(i, j + 1, m, n);
    // }

    // public int uniquePaths(int m, int n) {
    //     int dp[][]=new int[m][n];
    //     return sol(m,n,0,0,dp);
    // }
    // static int sol(int m,int n,int cr,int cc,int[][] dp){
    //     if(cr>=m || cc>=n || cr<0 || cc<0 ) return 0;
    //     if(cr==m-1 && cc==n-1) return 1;
    //     if(dp[cr][cc]!=0) return dp[cr][cc];
    //     int r=sol(m,n,cr,cc+1,dp);
    //     int d=sol(m,n,cr+1,cc,dp);
    //     dp[cr][cc]=r+d;
    //     return r+d;
    // }

    public int uniquePaths(int m, int n){
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}