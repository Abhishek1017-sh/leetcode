class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        boolean[][] visited=new boolean[n][n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,grid[0][0]});
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int r=curr[0],l=curr[1],h=curr[2];
            if(visited[r][l]) continue;
            visited[r][l]=true;
            if(r==n-1 && l==n-1){
                return h;
            }
            for(int[] d:dirs){
                int nr=r+d[0];
                int nc=l+d[1];
                if(nr>=0 && nr<n && nc>=0 && nc<n && !visited[nr][nc]){
                    pq.add(new int[]{nr,nc,Math.max(h,grid[nr][nc])});
                }
            }
        }
        return -1;
    }
}