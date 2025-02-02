class Solution {
    public boolean check(int[] nums) {
        if(nums.length<=1) return true;
        int c=0;
        for(int i=1;i<nums.length;++i){
            if(nums[i]<nums[i-1]){
                ++c;
            }
        }
        if(nums[0]<nums[nums.length-1]){
            ++c;
        }
        return c<=1;
    }
}