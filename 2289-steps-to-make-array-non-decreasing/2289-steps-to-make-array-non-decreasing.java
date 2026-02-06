class Solution {
    public int totalSteps(int[] nums) {
        Stack<int[]> st = new Stack<>();
        int ans = 0;
        for(int i=nums.length-1;i>=0;i--){
            int count=0;
            while(!st.isEmpty() && nums[st.peek()[0]]<nums[i]){
                count=Math.max(count+1,st.peek()[1]);
                st.pop();
            }
            st.push(new int[]{i,count});
            ans=Math.max(count,ans);
        }
        return ans;
    }
}