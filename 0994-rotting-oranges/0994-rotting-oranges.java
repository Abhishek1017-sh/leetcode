class Pair{
    int first;
    int second;
    int tm;
    Pair(int first,int second,int tm){
        this.first=first;
        this.second=second;
        this.tm=tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int[][] vis=new int[m][n];
        int cntfresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1) cntfresh++;
            }
        }
        int tm=0;
        int[] dr={-1,0,1,0};
        int[] dc={0,-1,0,1};
        int cnt=0;
        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            int time=q.peek().tm;
            tm=Math.max(time,tm);
            q.remove();
            for(int i=0;i<4;i++){
                int nrow=r+dr[i];
                int ncol=c+dc[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 
                && grid[nrow][ncol]==1){
                    q.add(new Pair(nrow,ncol,tm+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=cntfresh){
            return -1;
        }
        return tm;
    }
}