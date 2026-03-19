class Solution {
    static void dfs(char[][] board,int[][] vis,int m,int n,int row,int col){
        vis[row][col]=1;
        int[] dr={-1,0,1,0};
        int[] dc={0,-1,0,1};
        for(int i=0;i<4;i++){
            int nrow=row+dr[i];
            int ncol=col+dc[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 
            && board[nrow][ncol]=='O'){
                dfs(board,vis,m,n,nrow,ncol);
            }
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int[][] vis=new int[m][n];
        for(int j=0;j<n;j++){
            if(vis[0][j]==0 && board[0][j]=='O'){
                dfs(board,vis,m,n,0,j);
            }
            if(vis[m-1][j]==0 && board[m-1][j]=='O'){
                dfs(board,vis,m,n,m-1,j);
            }
        }
        for(int i=0;i<m;i++){
            if(vis[i][0]==0 && board[i][0]=='O'){
                dfs(board,vis,m,n,i,0);
            }
            if(vis[i][n-1]==0 && board[i][n-1]=='O'){
                dfs(board,vis,m,n,i,n-1);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
}