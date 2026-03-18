class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int[][] vis=new int[rows][cols];
        int cnt=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    cnt++;
                    bfs(vis,grid,i,j);
                }
            }
        }
        return cnt;
    }
    static void bfs(int[][] vis,char[][] grid,int i,int j){
        vis[i][j]=1;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i,j));
        int rows=grid.length;
        int cols=grid[0].length;
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            q.remove();
            int[] dr={-1,0,1,0};
            int[] dc={0,-1,0,1};
            for(int b=0;b<4;b++){
                int nrow=row+dr[b];
                int ncol=col+dc[b];
                if(nrow>=0 && nrow<rows && ncol>=0 && ncol<cols &&
                vis[nrow][ncol]==0 && grid[nrow][ncol]=='1'){
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
    }
}