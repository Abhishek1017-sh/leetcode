class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans=new int[nums.length];
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        int N=nums.length;
        for(int i=0;i<N;i++){
            boolean flag=false;
            for(int j=i+1;j<i+N;j++){
                if(nums[i]<nums[j%N]){
                    flag=true;
                    ans[i]=nums[j%N];
                    break;
                }
            }
            if(!flag){
                ans[i]=-1;
            }
        }
        return ans;
    }
}