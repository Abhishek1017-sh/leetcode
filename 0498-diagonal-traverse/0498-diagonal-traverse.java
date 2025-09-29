class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        Queue<Integer> queue=new LinkedList<>();
        for(int col=0;col<n;col++){
            int i=0;
            int j=col;
            while(i<m && j>=0){
                if((i+j)%2==0){
                    stack.add(mat[i][j]);
                }else{
                    queue.add(mat[i][j]);
                }
                i++;
                j--;
            }
            while(!queue.isEmpty()){
                ans.add(queue.poll());
            }
            while(!stack.isEmpty()){
                ans.add(stack.pop());
            }
        }
        for(int row=1;row<m;row++){
            int i=row;
            int j=n-1;
            while(i<m && j>=0){
                if((i+j)%2==0){
                    stack.add(mat[i][j]);
                }else{
                    queue.add(mat[i][j]);
                }
                i++;
                j--;
            }
            while(!queue.isEmpty()){
                ans.add(queue.poll());
            }
            while(!stack.isEmpty()){
                ans.add(stack.pop());
            }
        }
        int[] res = new int[ans.size()];
        for (int k = 0; k < ans.size(); k++) {
            res[k] = ans.get(k);
        }
        return res;
    }
}