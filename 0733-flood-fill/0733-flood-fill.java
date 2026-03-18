class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initial=image[sr][sc];
        if(initial==color) return image;
        dfs(image,sr,sc,initial,color);
        return image;
    }
    static void dfs(int[][] image,int i,int j,int initial,int color){
        int rows=image.length;
        int cols=image[0].length;
        if(i<0 || i>=rows || j<0 || j>=cols || image[i][j]!=initial) return;
        int[] dr={-1,0,1,0};
        int[] dc={0,-1,0,1};
        image[i][j]=color;
        for(int k=0;k<4;k++){
            int nrow=i+dr[k];
            int ncol=j+dc[k];
            dfs(image,nrow,ncol,initial,color);
        }
    }
}