class Solution {
    public int uniquePathsIII(int[][] grid) {
        int cnt=0;
        int tr=0;
        int tc=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!= -1) cnt++;
                if(grid[i][j]==1){
                    tr=i;
                    tc=j;
                }
            }
        }
        return sol(grid,tr,tc,cnt);
    }
    static int sol(int[][] grid,int cr,int cc,int remain){
        if(cr<0 || cc<0 || cr>=grid.length || cc>=grid[0].length || grid[cr][cc]==-1){
            return 0;
        }
        if(grid[cr][cc]==2){
           return (remain==1) ? 1 : 0; 
        }
        int temp=grid[cr][cc];
        grid[cr][cc]=-1;
        int path=0;
        path+=sol(grid,cr,cc-1,remain-1);
        path+=sol(grid,cr,cc+1,remain-1);
        path+=sol(grid,cr-1,cc,remain-1);
        path+=sol(grid,cr+1,cc,remain-1);
        grid[cr][cc]=temp;
        return path;
    }
}