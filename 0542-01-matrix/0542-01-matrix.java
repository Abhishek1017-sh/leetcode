class Pair{
    int first;
    int second;
    int dist;
    Pair(int first,int second,int dist){
        this.first=first;
        this.second=second;
        this.dist=dist;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] vis=new int[m][n];
        int[][] dist=new int[m][n];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        int[] dr={-1,0,1,0};
        int[] dc={0,-1,0,1};
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            int d=q.peek().dist;
            q.remove();
            dist[row][col]=d;
            for(int i=0;i<4;i++){
                int nrow=row+dr[i];
                int ncol=col+dc[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 
                && mat[nrow][ncol]==1){
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol,d+1));
                }
            }
        }
        return dist;
   }
}