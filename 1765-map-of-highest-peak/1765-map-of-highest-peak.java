class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length;
        int cols = isWater[0].length;
        int[][] ans = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(isWater[i][j]==1){
                    ans[i][j] = 0;
                    queue.offer(new int[]{i,j});
                }
                else{
                    ans[i][j] = -1;
                }
            }
        }
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        while(!queue.isEmpty()){
            int cell[] = queue.poll();
            int r = cell[0];
            int c = cell[1];
            int h = ans[r][c];
            for(int i=0;i<4;i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if(nr>=0 && nr<rows && nc>=0 && nc<cols && ans[nr][nc]==-1){
                    ans[nr][nc] = h+1;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
        return ans;
    }
}