class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans=0;
        int temp=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                temp++;
            }
            else{
                ans=Math.max(ans,temp);
                temp=1;
            }
        }
        ans=Math.max(ans,temp);
        temp=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                temp++;
            }
            else{
                ans=Math.max(ans,temp);
                temp=1;
            }
        }
        ans=Math.max(ans,temp);
        return ans;
    }
}