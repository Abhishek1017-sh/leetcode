class Solution {
    public int getMaximumGold(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    max=Math.max(max,sol(grid,i,j,m,n));
                }
            }
        }
        return max;
    }
    static int sol(int[][] grid,int cr,int cc,int m,int n){
        if(cr<0 || cc<0 || cr>=m || cc>=n || grid[cr][cc]==0){
            return 0;
        }
        int gold=grid[cr][cc];
        grid[cr][cc]=0;

        int left=sol(grid,cr,cc-1,m,n);
        int right=sol(grid,cr,cc+1,m,n);
        int up=sol(grid,cr-1,cc,m,n);
        int down=sol(grid,cr+1,cc,m,n);

        grid[cr][cc]=gold;

        return gold+Math.max(Math.max(up, down), Math.max(left, right));
    }
}