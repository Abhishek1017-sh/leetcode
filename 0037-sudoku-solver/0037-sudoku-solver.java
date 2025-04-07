class Solution {
    static boolean rules(char[][] board,int row,int col,char digit){
        for(int i=0;i<9;i++){
            if(board[row][i]==digit || board[i][col]==digit){
                return false;
            }
        }
        int strow=(row/3)*3;
        int stcol=(col/3)*3;
        for(int i=strow;i<strow+3;i++){
            for(int j=stcol;j<stcol+3;j++){
                if(board[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean helper(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        if(rules(board,i,j,k)){
                            board[i][j]=k;
                            if(helper(board)){
                                return true;
                            }
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        helper(board);
    }
}