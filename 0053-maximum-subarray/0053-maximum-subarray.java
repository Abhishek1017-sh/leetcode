class Solution {
    public int maxSubArray(int[] nums) {
        int sum=nums[0];
        int a=nums[0];
        for(int i=1;i<nums.length;i++){
            a=Math.max(nums[i],a+nums[i]);
            sum=Math.max(sum,a);
        }
        return sum;
    }
}