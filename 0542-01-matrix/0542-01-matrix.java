class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        Queue<int[]> q=new LinkedList<>();
        int[][] dist=new int[n][m];
        for(int[] d:dist){
            Arrays.fill(d,Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    dist[i][j]=0;
                    q.add(new int[]{i,j,0});
                }
            }
        }
        int[] dr={-1,0,0,1};
        int[] dc={0,-1,1,0};
        while(!q.isEmpty()){
            int[] poll=q.poll();
            int x=poll[0], y=poll[1], di=poll[2];
            for(int i=0;i<4;i++){
                int nr=x+dr[i];
                int nc=y+dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && mat[nr][nc]==1){
                    if(dist[nr][nc]>di+1){
                        dist[nr][nc]=di+1;
                        q.add(new int[]{nr,nc,di+1});
                    }
                }
            }
        }
        return dist;
    }
}