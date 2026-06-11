class Solution {
    public int maxSubArray(int[] nums) {
        int sum=nums[0];
        int curr=nums[0];
        for(int i=1;i<nums.length;i++){
            curr=Math.max(nums[i],curr+nums[i]);
            sum=Math.max(sum,curr);
        }
        return sum;
    }
}