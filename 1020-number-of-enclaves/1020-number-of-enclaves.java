class Solution {
    static void dfs(int[][] grid,int[][] vis,int m,int n,int row,int col){
        vis[row][col]=1;
        int[] dr={-1,0,1,0};
        int[] dc={0,-1,0,1};
        for(int i=0;i<4;i++){
            int nrow=row+dr[i];
            int ncol=col+dc[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 
            && grid[nrow][ncol]==1){
                dfs(grid,vis,m,n,nrow,ncol);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];
        for(int j=0;j<n;j++){
            if(vis[0][j]==0 && grid[0][j]==1){
                dfs(grid,vis,m,n,0,j);
            }
            if(vis[m-1][j]==0 && grid[m-1][j]==1){
                dfs(grid,vis,m,n,m-1,j);
            }
        }
        for(int i=0;i<m;i++){
            if(vis[i][0]==0 && grid[i][0]==1){
                dfs(grid,vis,m,n,i,0);
            }
            if(vis[i][n-1]==0 && grid[i][n-1]==1){
                dfs(grid,vis,m,n,i,n-1);
            }
        }
        int c=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    c++;
                }
            }
        }
        return c;
    }
}