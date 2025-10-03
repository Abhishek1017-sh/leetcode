class Solution {
    public boolean exist(char[][] board, String word) {
        int er=board.length-1;
        int ec=board[0].length-1;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char ch=board[i][j];
                if(ch==word.charAt(0)){
                    if(sol(board,word,i,j,er,ec,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    static boolean sol(char[][] arr,String word,int cr,int cc,int er,int ec,int idx){
        if(idx==word.length()){
            return true;
        }
        if(cr<0 || cc<0 || cr>er || cc>ec || arr[cr][cc]=='*'){
            return false;
        }
        char ch=arr[cr][cc];
        if(ch==word.charAt(idx)){
            arr[cr][cc]='*';
            boolean up=sol(arr,word,cr-1,cc,er,ec,idx+1);
            if(up) return true;
            boolean down=sol(arr,word,cr+1,cc,er,ec,idx+1);
            if(down) return true;
            boolean left=sol(arr,word,cr,cc-1,er,ec,idx+1);
            if(left) return true;
            boolean right=sol(arr,word,cr,cc+1,er,ec,idx+1);
            if(right) return true;
            arr[cr][cc]=ch;
        }
        return false;
    }
}