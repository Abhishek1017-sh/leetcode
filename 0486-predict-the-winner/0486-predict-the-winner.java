class Solution {
    public boolean predictTheWinner(int[] nums) {
        if(nums==null || nums.length==0) return true;
        return sol(nums,0,nums.length-1) >= 0;
    }
    static int sol(int[] nums,int l,int r){
        if(l==r) return nums[l];
        int pickleft=nums[l]-sol(nums,l+1,r);
        int pickright=nums[r]-sol(nums,l,r-1);
        return Math.max(pickleft,pickright);
    }
}