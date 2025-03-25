class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] pre=new int[n];
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && heights[i]<=heights[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                pre[i]=-1;
            }
            else{
                pre[i]=stack.peek();
            }
            stack.push(i);
        }
        int[] next=new int[n];
        ArrayDeque<Integer> st=new ArrayDeque<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                next[i]=n;
            }
            else{
                next[i]=st.peek();
            }
            st.push(i);
        }
        int max=0;
        for(int i=0;i<n;i++){
            int curr=(next[i]-pre[i]-1)*heights[i];
            max=Math.max(curr,max);
        }
        return max;
    }
}