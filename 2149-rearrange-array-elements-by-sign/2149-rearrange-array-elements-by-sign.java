class Solution {
    public int[] rearrangeArray(int[] nums) {
        int low=0;
        int high=1;
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                ans[low]=nums[i];
                low+=2;
            }
            else{
                ans[high]=nums[i];
                high+=2;
            }
        }
        return ans;
    }
}