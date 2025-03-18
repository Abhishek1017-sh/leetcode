class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans=new int[nums.length];
        Stack<Integer> stack=new Stack<>();
        int N=nums.length;
        for(int i=2*N-1;i>=0;i--){
            while(!stack.isEmpty() && nums[i%N]>=stack.peek()){
                stack.pop();
            }
            if(i<N){
                if(stack.isEmpty()){
                    ans[i%N]=-1;
                }
                else{
                    ans[i%N]=stack.peek();
                }
            }
            stack.push(nums[i%N]);
        }
        return ans;
    }
}